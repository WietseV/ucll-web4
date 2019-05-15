package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.RequestHandler;
import domain.ChatConv;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendMsg extends RequestHandler
{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        if (person != null) {
            String userID = request.getParameter("userId");
            userID = userID.toLowerCase() + "@ucll.be";
            ChatConv rightConv = null;
            if (person.getFriends().contains(getPersonService().getPerson(userID))) {
                for (ChatConv conv : this.getPersonService().Chatconvs) {
                    if ((conv.me.getUserId().equals(person.getUserId()) && conv.other.getUserId().equals(userID)) ||
                            (conv.other.getUserId().equals(person.getUserId()) && conv.me.getUserId().equals(userID))) {
                        rightConv = conv;
                        break;
                    }
                }
                if(rightConv== null) {
                    rightConv = new ChatConv(person, getPersonService().getPerson(userID));
                    this.getPersonService().Chatconvs.add(rightConv);
                }

                if (!request.getParameter("message").isEmpty()) {
                    rightConv.chat.add(person.getFirstName()+" "+ person.getLastName() + ": " +request.getParameter("message"));
                }
            }
        }
        return null;
    }
}
