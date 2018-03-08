package com.wrox.pj4w.ch10.servlet;

import com.wrox.pj4w.ch10.game.TicTacToeGame;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ticTacToeServlet",
        urlPatterns = "/ticTacToe"
)
public class TicTacToeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pendingGames", TicTacToeGame.getPendingGames());
        view("list", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if("join".equalsIgnoreCase(action)) {
            String gameIdString = req.getParameter("gameId");
            String username = req.getParameter("username");
            if(username == null || gameIdString == null || !NumberUtils.isDigits(gameIdString)) {
                list(req, resp);
            } else {
                req.setAttribute("action", "join");
                req.setAttribute("username", username);
                req.setAttribute("gameId", Long.parseLong(gameIdString));
                view("game", req, resp);
            }
        } else if("start".equalsIgnoreCase(action)) {
            String username = req.getParameter("username");
            if(username == null) {
                list(req, resp);
            } else {
                req.setAttribute("action", "start");
                req.setAttribute("username", username);
                req.setAttribute("gameId", TicTacToeGame.queueGame(username));
                view("game", req, resp);
            }
        } else {
            list(req, resp);
        }
    }

    private void view(String view, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/ticTacToe/" + view + ".jsp")
                .forward(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/ticTacToe"));
    }
}

