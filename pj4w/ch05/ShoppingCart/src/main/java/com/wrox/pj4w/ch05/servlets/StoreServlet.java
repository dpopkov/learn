package com.wrox.pj4w.ch05.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(
        name = "storeServlet",
        urlPatterns = {"/shop"}
)
public class StoreServlet extends HttpServlet {
    private final Map<Integer, String> products = new Hashtable<>();

    public StoreServlet() {
        products.put(1, "Sandpaper");
        products.put(2, "Nails");
        products.put(3, "Glue");
        products.put(4, "Paint");
        products.put(5, "Tape");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "browse";
        }
        switch (action) {
            case "addToCart":
                addToCart(req, resp);
                break;
            case "viewCart":
                viewCart(req, resp);
                break;
            case "emptyCart":
                emptyCart(req, resp);
                break;
            case "browse":
            default:
                browse(req, resp);
                break;
        }
    }

    private void emptyCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("cart");
        resp.sendRedirect("shop?action=viewCart");
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId;
        try {
            productId = Integer.parseInt(req.getParameter("productId"));
        } catch (Exception e) {
            resp.sendRedirect("shop");
            return;
        }

        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new Hashtable<Integer, Integer>());
        }

        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart = (Map<Integer, Integer>)session.getAttribute("cart");
        if (!cart.containsKey(productId)) {
            cart.put(productId, 0);
        }
        cart.put(productId, cart.get(productId) + 1);

        resp.sendRedirect("shop?action=viewCart");
    }

    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp")
                .forward(req, resp);
    }

    private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")
                .forward(req, resp);
    }
}
