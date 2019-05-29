package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetPraktijkExamens extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<PraktijkExamenSheet> list = (List) this.getPersonService().getPraktijkExamens();
        return this.toJSON(list);
    }



    public String toJSON (List<PraktijkExamenSheet> list){
        ObjectMapper mapper = new ObjectMapper();
        String error;
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            error = e.toString();
        }
        return error;
    }
}
