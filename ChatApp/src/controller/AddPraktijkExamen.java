package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PraktijkExamen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPraktijkExamen extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String praktijkExamenTitle = (String) request.getParameter("title");
        String praktijkExamenDate = (String) request.getParameter("date");
        String praktijkExamenYear = (String) request.getParameter("year");
        PraktijkExamen pE = new PraktijkExamen(praktijkExamenDate, praktijkExamenTitle, praktijkExamenYear);
        this.getPersonService().addPraktijkExamen(pE);
        return praktijkExamenTitle;
    }



    public String toJSON (domain.PraktijkExamen pE) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(pE);
    }
}
