package com.example.demo.servelt;

import com.example.demo.Test.Log;
import com.example.demo.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/logs")
public class Showlogs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        String email = (String) httpSession.getAttribute("email");
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "select * from logs where user_email= ?";
            List<Log> logs = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                logs.add(new Log(
                        resultSet.getInt(1),
                        resultSet.getTimestamp(2),
                        resultSet.getString(3)
                ));
            req.setAttribute("logs", logs);
            req.getRequestDispatcher("logs.jsp").forward(req, resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
