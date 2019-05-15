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
<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</div>
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="Controller?action=LogIn">
			<p>
				<label for="email">Your email </label>
				<input type="text" id="email" name="email" value="jan@ucll.be">
			</p>
			<p>
				<label for="password">Your password</label>
				<input type="password" id="password" name="password" value="t">
			</p>
			<p>
				<input type="submit" id="loginbutton" value="Log in">
			</p>
		</form>
	</c:otherwise>
</c:choose>


		<h2>Was het een interessante projectweek?</h2>
		<div id="messages1"></div>
		<input type="text" id="name1" name="name" placeholder="name">
		<input type="text" id="comment1" name="comment" placeholder="comment">
		<input type="number" id="rating1" name="rating" placeholder="1-10" min="1" max="10">
		<input type="submit" id="submit" value="submit" onclick="send1();">

		<h2>Wat ben je van plan om te doen vandaag?</h2>
		<div id="messages2"></div>
		<input type="text" id="name2" name="name" placeholder="name">
		<input type="text" id="comment2" name="comment" placeholder="comment">
		<input type="number" id="rating2" name="rating" placeholder="1-10" min="1" max="10">
		<input type="submit" id="submit" value="submit" onclick="send2();">

		<h2>Naar welke muziek ben je momenteel aan het luisteren?</h2>
		<div id="messages3"></div>
		<input type="text" id="name3" name="name" placeholder="name">
		<input type="text" id="comment3" name="comment" placeholder="comment">
		<input type="number" id="rating3" name="rating" placeholder="1-10" min="1" max="10">
		<input type="submit" id="submit" value="submit" onclick="send3();">

		<h2>Wat zijn de examenvragen voor het vak Web4?</h2>
		<div id="messages4"></div>
		<input type="text" id="name4" name="name" placeholder="name">
		<input type="text" id="comment4" name="comment" placeholder="comment">
		<input type="number" id="rating4" name="rating" placeholder="1-10" min="1" max="10">
		<input type="submit" id="submit" value="submit" onclick="send4();">

		<h2>Werkt deze opdracht?</h2>
		<div id="messages5"></div>
		<input type="text" id="name5" name="name" placeholder="name">
		<input type="text" id="comment5" name="comment" placeholder="comment">
		<input type="number" id="rating5" name="rating" placeholder="1-10" min="1" max="10">
		<input type="submit" id="submit" value="submit" onclick="send5();">


		<script type="text/javascript">
			window.onload = openSocket;
			var webSocket;
			var messages = document.getElementById("messages");

			function openSocket(){
				webSocket = new WebSocket("ws://localhost:8080/ChatApp_war_exploded/Blog");

				webSocket.onopen = function(event){
					writeResponse("Connection opened")
				};


				webSocket.onmessage = function(event){
					writeResponse(event.data);
				};
			}

			function send1(){
				var text = "1" + document.getElementById("name1").value + " : " + document.getElementById("comment1").value + " " + document.getElementById("rating1").value;
				webSocket.send(text);
			}
			function send2(){
				var text = "2" + document.getElementById("name2").value + " : " + document.getElementById("comment2").value + " " + document.getElementById("rating2").value;
				webSocket.send(text);
			}
			function send3(){
				var text = "3" + document.getElementById("name3").value + " : " + document.getElementById("comment3").value + " " + document.getElementById("rating3").value;
				webSocket.send(text);
			}
			function send4(){
				var text = "4" + document.getElementById("name4").value + " : " + document.getElementById("comment4").value + " " + document.getElementById("rating4").value;
				webSocket.send(text);
			}
			function send5(){
				var text = "5" + document.getElementById("name5").value + " : " + document.getElementById("comment5").value + " " + document.getElementById("rating5").value;
				webSocket.send(text);
			}

			function closeSocket(){
				webSocket.close();
			}

			function writeResponse(text){
				if (text.charAt(0) === "1"){
					text = text.substr(1,text.length-1);
					messages1.innerHTML+= "<br/>" + text;
				}
				if (text.charAt(0) === "2"){
					text = text.substr(1,text.length-1);
					messages2.innerHTML+= "<br/>" + text;
				}
				if (text.charAt(0) === "3"){
					text = text.substr(1,text.length-1);
					messages3.innerHTML+= "<br/>" + text;
				}
				if (text.charAt(0) === "4"){
					text = text.substr(1,text.length-1);
					messages4.innerHTML+= "<br/>" + text;
				}
				if (text.charAt(0) === "5"){
					text = text.substr(1,text.length-1);
					messages5.innerHTML+= "<br/>" + text;
				}
				else{
					messages.innerHTML+= "<br/>" + text;
				}
			}


		</script>

	</main>


	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
</body>
</html>