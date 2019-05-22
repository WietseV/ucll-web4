package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.PersonService;
import domain.Role;

public class SignUp extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        String destination = "index.jsp";
        List<String> errors = new ArrayList<String>();

        String firstname = request.getParameter("firstname");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        Integer age = (Integer) Integer.parseInt( request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatpassword = request.getParameter("repeatpassword");

        if (email == null || email.isEmpty()) {
            errors.add("No email given");
        }

        if (firstname == null || firstname.isEmpty()) {
            errors.add("No first name given");
        }

        if (name == null || name.isEmpty()) {
            errors.add("No last name given");
        }

        if (age == null || age.toString().isEmpty()) {
            errors.add("No age given");
        }

        if (gender == null || gender.isEmpty()){
            errors.add("No gender given");
        }


        if (password == null || password.isEmpty()) {
            errors.add("No password given");
        }

        if (! password.equals(repeatpassword)){
            errors.add("");
        }




        if (errors.size() == 0) {
            PersonService personService = super.getPersonService();
            Person person = new Person(email, password, firstname, name,Role.LID, "Offline", gender, age);
            personService.addPerson(person);
        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            destination = "signUp.jsp";
        }
        return destination;
    }

}
