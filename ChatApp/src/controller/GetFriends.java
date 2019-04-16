package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.RequestHandler;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetFriends extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        request.setAttribute("person", person);
        List<Person> friends = person.getFriends();
            return this.toJSON(friends);
    }



    public String toJSON (List<Person> friends){
        ObjectMapper mapper = new ObjectMapper();
        String error;
        try {
            return mapper.writeValueAsString(friends);
        } catch (JsonProcessingException e) {
            error = e.toString();
        }
        return error;
    }
}
