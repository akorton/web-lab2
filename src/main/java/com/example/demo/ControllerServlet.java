package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ControllerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log(request.getQueryString());
        if (request.getQueryString() == null)
            request.getRequestDispatcher("/hello/index.jsp").forward(request, response);
        else{
            if (request.getQueryString().equals("getPoints")) request.getRequestDispatcher("/command/getPoints").forward(request, response);
            else request.getRequestDispatcher("/command/checkArea").forward(request, response);
        }
    }
}