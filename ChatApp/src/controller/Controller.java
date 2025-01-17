package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;
import domain.PraktijkExamenService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService model = new PersonService();
	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String async = request.getParameter("async");
        String destination = "index.jsp";
            if (action != null || async != null) {
                RequestHandler handler;
                try {
                    if (action == null){
                        handler = controllerFactory.getController(async, model);
                    }else {
                        handler = controllerFactory.getController(action, model);
                    }
                    destination = handler.handleRequest(request, response);
                }
                catch (NotAuthorizedException exc) {
                    List<String> errors = new ArrayList<String>();
                    errors.add(exc.getMessage());
                    request.setAttribute("errors", errors);
                    destination="index.jsp";
                }
            }
            if (async == null) {
                RequestDispatcher view = request.getRequestDispatcher(destination);
                view.forward(request, response);
            }
            else {
                response.setContentType("text/json");
                response.getWriter().write(destination);
            }

	}

}
