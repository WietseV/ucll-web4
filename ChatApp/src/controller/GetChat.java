package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ChatConv;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetChat extends RequestHandler {

    public String toJson(List<String> list){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            return null;
        }

    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String result = "";
        if (person != null) {
            String userName = request.getParameter("userName");
            String userID = userName.toLowerCase() + "@ucll.be";
            ChatConv rightConv = null;
            if (person.getFriends().contains(getPersonService().getPerson(userID))) {
                for (ChatConv conv : this.getPersonService().Chatconvs) {
                    if (conv.me.getUserId().equals(person.getUserId()) && conv.other.getUserId().equals(userID) ||
                            conv.other.getUserId().equals(person.getUserId()) && conv.me.getUserId().equals(userID)) {
                        rightConv = conv;
                        break;
                    }
                }
                if (rightConv == null) {
                    rightConv = new ChatConv(person, getPersonService().getPerson(userID));
                    this.getPersonService().Chatconvs.add(rightConv);
                    rightConv.chat.add("Conversation started!");
                }
                result = this.toJson(rightConv.chat);
                response.setContentType("application/json");
                response.getWriter().write(result);

            }
        }
        return "";
    }
}
