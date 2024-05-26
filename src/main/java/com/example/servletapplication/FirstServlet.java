package com.example.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "firstServlet", value = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("MY_HEADER", "Hi");

        PrintWriter writer = resp.getWriter();

        String info = req.getHeader("user-agent");
        writer.println("<html><body>");
        writer.println("<h1>Hello world!</h1>");
        writer.println("<h2>Info: " + info + "</h2>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            writer.println("<h3> " + headerName + " : " + req.getHeader(headerName) + "</h3>");
        }

        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        writer.println("<h2>Login: " + req.getParameter("login") + "</h2>");
        writer.println("<h2>Password: " + req.getParameter("password") + "</h2>");*/

        resp.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}
