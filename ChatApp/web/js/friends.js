window.onload = x;

var xHRObjectFriends = new XMLHttpRequest();
//var updateStatusRequest = new XMLHttpRequest();

/**function updateStatus () {
    var statusText = document.getElementById("statustext").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    var information = "status=" + encodeURIComponent(statusText);
    updateStatusRequest.open("POST", "Controller?async=UpdateStatus", true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    updateStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    updateStatusRequest.send(information);
    getCurrentStatus();
}**/

function x(){
    getCurrentStatus();
    getFriends();
}

function getFriends() {
    xHRObjectFriends.open("GET", "Controller?async=GetFriends", true);
    xHRObjectFriends.onreadystatechange = getDataFriends;
    xHRObjectFriends.send(null);
}

function getDataFriends () {
    if (xHRObjectFriends.status == 200) {
        if (xHRObjectFriends.readyState == 4) {
            alert(xHRObjectFriends.responseText);
            var serverResponse = JSON.parse(xHRObjectFriends.responseText);
            var friends = serverResponse; // of je kan ook doen: serverResponse["status"]

            var friendsDiv = document.getElementById("friends");
            var friendsParagraph = friendsDiv.childNodes[0];
            if (friendsParagraph == null) {
                friendsParagraph = document.createElement('p');
                friendsParagraph.id = "friendsText";
                var friendsText = document.createTextNode(friends);
                friendsParagraph.appendChild(friendsText);
                friendsDiv.appendChild(friendsParagraph);
            }
            else {
                var friendsText = document.createTextNode(friends);
                friendsParagraph.removeChild(friendsParagraph.childNodes[0]);
                friendsParagraph.appendChild(friendsText);
            }/**
             var div = document.getElementById("status");
             var p = document.createElement("p");
             alert("toch iets");
             alert(xHRObject.responseText);
             var text = document.createTextNode(xHRObject.responseText);
             alert(xHRObject.responseText);
             p.appendChild(text);
             div.appendChild(p);**/
            setTimeout(getFriends, 2000);
        }
    }
}