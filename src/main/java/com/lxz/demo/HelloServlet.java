package com.lxz.demo;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder("");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "lxz", "Lxz19970309.")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select emp_id, fname, lname from employee");
            while (rs.next()) {
                stringBuilder.append(rs.getInt(1));
                stringBuilder.append(": ");
                stringBuilder.append(rs.getString(2));
                stringBuilder.append(" ");
                stringBuilder.append(rs.getString(3));
                stringBuilder.append("\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        out.println(stringBuilder.toString());
    }
}

