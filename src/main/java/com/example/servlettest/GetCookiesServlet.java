package com.example.servlettest;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "GetCookiesServlet", value = "/get-cookies-servlet")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");

        for (Cookie cookie : cookies) {
            pw.println("<h1>" + cookie.getName() + " : " + cookie.getValue() + "</h1>");
        }

        pw.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
