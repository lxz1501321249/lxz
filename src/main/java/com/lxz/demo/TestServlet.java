package com.lxz.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer emp_id = null;
        try {
            emp_id = Integer.valueOf(req.getParameter("id"));
            //用户请求中如何带参数？
            //请求?参数名=参数值&参数名=参数值.....
            //req.getParameter()方法获得用户请求中某个参数的值
            System.out.println(emp_id);
        } catch (Exception e) {
            System.out.println("转换失败");
        }
        Integer yonghu = Integer.valueOf(req.getParameter("yonghu"));
        System.out.println(yonghu);
    }
}
