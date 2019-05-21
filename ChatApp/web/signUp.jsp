<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<main>

        <form method="post" action="Controller?action=SignUp">
            <p>
                <label for="firstname">Your firstname </label>
                <input type="text" id="firstname" name="firstname" placeholder="jan">
            </p>
            <p>
                <label for="name">Your name </label>
                <input type="text" id="name" name="name" placeholder="janssens">
            </p>
            <p>
                <label for="gender">Your gender </label>
                <input type="text" id="gender" name="gender" placeholder="Male">
            </p>
            <p>
                <label for="age">Your age </label>
                <input type="number" id="age" name="age" placeholder="bv. 21">
            </p>
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" placeholder="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" placeholder="test">
            </p>
            <p>
                <label for="repeatpassword">Repeat password</label>
                <input type="password" id="repeatpassword" name="repeatpassword" placeholder="test">
            </p>
            <p>
                <input type="submit" id="signupbutton" value="Sign up">
            </p>
        </form>



</main>


<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>
