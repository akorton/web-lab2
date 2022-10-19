package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log(request.getQueryString());
        if (request.getQueryString() == null)
            request.getRequestDispatcher("/hello/index.jsp").forward(request, response);
        else{
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.println("Some Attributes");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}