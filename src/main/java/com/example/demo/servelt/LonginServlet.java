package com.example.demo.servelt;

import com.example.demo.util.DbUtil;
import com.example.demo.util.Random64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import java.sql.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


@WebServlet("/login")
public class LonginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        AtomicReference<String> uNameInCookie = new AtomicReference<>("");
        AtomicReference<String> uPasswordInCookie = new AtomicReference<>("");
        AtomicReference<String> tokenInCookie = new AtomicReference<>("");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username"))
                uNameInCookie.set(cookie.getValue());
            if (cookie.getName().equals("password"))
                uPasswordInCookie.set(cookie.getValue());
            if (cookie.getName().equals("token"))
                tokenInCookie.set(cookie.getValue());
        }
        if (tokenInCookie.equals("")) {
            String uName = req.getParameter("username");
            String uPassword = DigestUtils.md5Hex(req.getParameter("password")).toUpperCase();
            AtomicReference<Boolean> remember = new AtomicReference<>(Boolean.valueOf(req.getParameter("remember")));

            try (Connection connection = DbUtil.getConnection()) {
                String sql = "select u_name from users where u_name = '" + uName + "' and u_password = '" + uPassword + "'";
                assert connection != null;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("username", uName);
                    resp.getWriter().println("succeed");
                    if (remember.get()) {
                        //想客户端写入cookie
                        Cookie username = new Cookie("username", uName);
                        Cookie password = new Cookie("password", uPassword);
                        Cookie token;
                        token = new Cookie("token", Random64.getRandom64());
                        //执行jdbc代码
                        statement.executeUpdate("update users set u_cokie ='" + token + "'where u_name = '" + uName + "'");
                        resp.addCookie(username);
                        resp.addCookie(password);
                        resp.addCookie(token);

                    }
                } else {
                    req.setAttribute("error", "用户名密码不正确");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
