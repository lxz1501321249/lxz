package com.example.demo.servelt;

import com.example.demo.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/log")
public class LogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection connection = DbUtil.getConnection()) {
            String sql = "select user_email from user where user_email = ? and user_password= ?";
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("email", email);
                Timestamp now =new Timestamp(System.currentTimeMillis());
                //更新
                sql= "update user set user_count =user_count +1 ," +
                        " user_last_login_time = ? " +
                        "where user_email = ? ";
                preparedStatement =connection.prepareStatement(sql);
                preparedStatement.setTimestamp(1,now);
                preparedStatement.setString(2,email);
                preparedStatement.executeUpdate();
                //插入登录
                sql="insert into logs(log_login_time, user_email)values (?, ?)";
                preparedStatement =connection.prepareStatement(sql);
                preparedStatement.setTimestamp(1,now);
                preparedStatement.setString(2,email);
                preparedStatement.executeUpdate();

                req.getRequestDispatcher("logs.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "用户名或密码输入错误");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
