package com.example.demo.servelt;


import com.example.demo.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection connection = DbUtil.getConnection()) {
            String sql = "select user_email from user where user_email = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {//结果为true，意味着email存在
                req.setAttribute("error", "邮箱已存在");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } else if (password.length() < 8) {
                req.setAttribute("error", "密码小于8位");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } else {
                sql = "insert into user(user_email,user_password)value (?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                req.getRequestDispatcher("index.html").forward(req, resp);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
