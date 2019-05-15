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


    </div>

    <div>
        <label>Change status</label>
        <input list="statuslist" name="statustext" id="statustext"/>
        <datalist id="statuslist">
            <option value="Online">
            <option value="Offline">
            <option value="Away">
        </datalist>

        <input type="button" id="statusbutton" value="Change" onclick="updateStatus();"/>
        <script type="text/javascript" src="js/status.js"></script>
    </div>


    <button type="button" id="toggleButton">Add Friend</button>
    <div id="add">
        <label>Add friend</label>
        <input name="friendtext" id="friendtext"/>

        <input type="button" id="friendbutton" value="Add" onclick="addFriend();"/>
        <input type="button" id="cancelFriend" value="Cancel" />
        <script type="text/javascript" src="js/chat.js"></script>
        <script type="text/javascript" src="js/friends.js"></script>
    </div>

    <div id="chat">

            <h3 id="id"></h3>

            <ul id="chatText"></ul>

            <label for="msg"><b>Message</b></label>
            <input placeholder="Type message.." name="msg" id="msg"></input>

            <button type="submit" id="sendMsg" onclick="sendMessage()">Send</button>
            <button type="button" id="closeChat" onclick="closeChat()">Close</button>
    </div>
    <script>
        $(document).ready(function() {
            $("#chat").hide();
            $("#add").hide();
            $("#toggleButton").show();
            $("#toggleButton").click(function () {
                $("#add").show();
                $("#toggleButton").hide();
            });
            $("#cancelFriend").click(function () {
                $("#add").hide();
                $("#toggleButton").show();
            });
        });
    </script>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
</body>
</html>