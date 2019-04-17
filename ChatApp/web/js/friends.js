window.onload = x;

var xHRObjectFriends = new XMLHttpRequest();
var xHRObjectAddFriend = new XMLHttpRequest();
//var updateStatusRequest = new XMLHttpRequest();

function addFriend () {
    var friendtext = document.getElementById("friendtext").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    var information = "friend=" + encodeURIComponent(friendtext);
    xHRObjectAddFriend.open("POST", "Controller?async=AddFriend", true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    xHRObjectAddFriend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRObjectAddFriend.send(information);
    getCurrentStatus();
}

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
            //alert(xHRObjectFriends.responseText);
            var serverResponse = JSON.parse(xHRObjectFriends.responseText);
            var friends = serverResponse; // of je kan ook doen: serverResponse["status"]

            var col = [];
            for (var i = 0; i < friends.length; i++) {
                for (var key in friends[i]) {
                    if (col.indexOf(key) === -1) {
                        col.push(key);
                    }
                }
            }

            // CREATE DYNAMIC TABLE.
            var table = document.createElement("table");

            // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

            var tr = table.insertRow(-1);// TABLE ROW.
            var th = document.createElement("th");
            th.innerHTML = "Name"
            tr.appendChild(th)
            var th = document.createElement("th");
            th.innerHTML = "Status"
            tr.appendChild(th)
            /**for (var i = 0; i < col.length; i++) {
                var th = document.createElement("th");      // TABLE HEADER.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }**/

            // ADD JSON DATA TO THE TABLE AS ROWS.
            for (var i = 0; i < friends.length; i++) {

                tr = table.insertRow(-1);

                for (var j = 0; j < col.length; j++) {
                    var tabCell = tr.insertCell(-1);
                    tabCell.innerHTML = friends[i][col[j]];
                }
            }

            // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
            var divContainer = document.getElementById("friends");
            divContainer.innerHTML = "";
            divContainer.appendChild(table);

            setTimeout(getFriends, 2000);
        }
    }
}