package ru.sberbank.jd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FirstServlet Name", value = "/hello")
public class FirstServlet extends HttpServlet {
    // GET HTTP: http://host:port/url-path?param1=value1&param2=value2
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String helloString = "Hello";

        var param1 = req.getParameter("param1");
        var param2 = req.getParameter("param2");

        resp.getOutputStream().write(helloString.getBytes());
        resp.getOutputStream().write(param1.getBytes());
        resp.getOutputStream().write(param2.getBytes());
        resp.getOutputStream().flush();
    }
}
