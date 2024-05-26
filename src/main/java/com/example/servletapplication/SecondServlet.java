package com.example.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(value = "/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        PrintWriter writer = resp.getWriter();

        writer.println("<h2>My name " + name + "</h2>");
        writer.println("<h2>My age " + age + "</h2>");

        Map<String, String[]> parameterMap = req.getParameterMap();

        parameterMap.forEach((key, value) -> System.out.println(key + " : " + Arrays.toString(value)));
    }
}
