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
    <div id="status"></div>

    <div id="friends">
        <table>
            <tr>
                <th>Name</th>
                <th>Status</th>
            </tr>
        </table>
    </div>

    <div>
        <label>Change status</label>
        <input list="statuslist" name="statustext" id="statustext"/></label>
        <datalist id="statuslist">
            <option value="Online">
            <option value="Offline">
            <option value="Away">
        </datalist>

        <input type="button" id="statusbutton" value="Change" onclick="updateStatus();"/>
        <script type="text/javascript" src="js/status.js"></script>
    </div>

    <div>
        <label>Add friend</label>
        <input name="friendtext" id="friendtext"/></label>

        <input type="button" id="friendbutton" value="Add" onclick="AddFriend();"/>
        <script type="text/javascript" src="js/friends.js"></script>
    </div>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
</body>
</html>