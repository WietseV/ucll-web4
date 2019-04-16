package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        request.setAttribute("person", person);
        String status = person.getStatus();
        return this.toJSON(person);
    }



    public String toJSON (Person person) {
        ObjectMapper mapper = new ObjectMapper();
        String error;
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            error = e.toString();
        }
        return error;
    }
}
