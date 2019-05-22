package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateFirstName extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        getPersonService().updateFirstName(request.getParameter("firstname"), getPersonService().getPerson(request.getParameter("email")));
        return toJSON( getPersonService().getPerson(request.getParameter("email")).getFirstName());
    }

    private String toJSON (String firstname) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"firstname\" : \"");
        json.append(firstname);
        json.append("\"}");

        return json.toString();
    }
}
