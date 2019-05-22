package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetPersons extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return toJSON(getPersonService().getPersons());
    }

    public String toJSON(List<Person> persons){
        String json = "[";
        int i = 0;
        for (Person person : persons){
            json += "{\"email\":\"" + person.getUserId() + "\"," +
                    "\"firstname\":\"" + person.getFirstName() + "\"," +
                    "\"lastname\":\"" + person.getLastName() + "\"," +
                    "\"gender\":\"" + person.getGender() + "\"," +
                    "\"age\":\"" + person.getAge() + "\"}";
            i++;
            if (persons.size() != i){
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}
