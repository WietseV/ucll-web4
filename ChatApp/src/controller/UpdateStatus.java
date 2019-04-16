package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateStatus extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        request.setAttribute("person", person);
        String status = (String)request.getParameter("status");
        person.setStatus(status);
        return status;
    }



    public String toJSON (Person person) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(person);
    }
}
