<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<main>
    <p>Welcome ${user.getFirstName()}!</p>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>