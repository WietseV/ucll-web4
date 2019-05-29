<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="PraktijkExamens" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="PraktijkExamens" />
</jsp:include>
<main>

    <div id="PE">


    </div>
        <label>Add PraktijkExamen</label>
        <input name="PEDate" id="PEDate" placeholder="date"/>
    <input name="PETitle" id="PETitle" placeholder="title"/>
    <input name="PEYear" id="PEYear" placeholder="year"/>
        <input type="button" id="PEButton" value="Add" onclick="addPE();"/>
    <script type="text/javascript" src="js/praktijkExamen.js"></script>


</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
</body>
</html>
