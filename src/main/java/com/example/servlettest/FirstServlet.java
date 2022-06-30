package com.example.servlettest;

import logic.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        Integer count = (Integer) session.getAttribute("count");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (cart == null) {
            cart = new Cart();

            cart.setName(name);
            cart.setQuantity(quantity);

        }
        session.setAttribute("cart", cart);

        getServletContext().getRequestDispatcher("/showcart.jsp").forward(request,response);

        if (count == null) {
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count+1);
        }


        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Your count is " + count +  "</h1>");
        pw.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
