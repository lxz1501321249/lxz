package com.example.demo.servelt;

import com.example.demo.util.DbUtil;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uName = req.getParameter("username");
        String uPassword1 = req.getParameter("password");
        if (uPassword1.length() < 8) {
            req.setAttribute("error", "密码必须大于8位");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        String uPassword = DigestUtils.md5Hex(uPassword1).toUpperCase();

        try (Connection connection = DbUtil.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select u_name from users where u_name = '" + uName + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                req.setAttribute("error", "用户名已存在");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } else if (!uPassword.equals("D41D8CD98F00B204E9800998ECF8427E")) {
                int i = statement.executeUpdate("insert into users(u_name, u_password) values ('" + uName + "', '" + uPassword + "')");
                if (i == 1) {
                    req.getRequestDispatcher("index.html").forward(req, resp);
                } else {
                    req.setAttribute("error", "未知错误");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}