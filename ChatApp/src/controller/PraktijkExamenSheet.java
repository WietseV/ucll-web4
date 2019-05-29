package controller;

import domain.PraktijkExamen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PraktijkExamenSheet extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        return "praktijkExamens.jsp";
    }
}
