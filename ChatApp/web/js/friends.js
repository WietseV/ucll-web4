window.onload = x;

var xHRObjectFriends = new XMLHttpRequest();
var xHRObjectAddFriend = new XMLHttpRequest();


function addFriend () {
    var friendtext = document.getElementById("friendtext").value;
    var information = "friend=" + encodeURIComponent(friendtext);
    xHRObjectAddFriend.open("POST", "Controller?async=AddFriend", true);
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
    if (xHRObjectFriends.status === 200) {
        if (xHRObjectFriends.readyState === 4) {
            var serverResponse = JSON.parse(xHRObjectFriends.responseText);
            var friends = serverResponse;

            var col = [];
            for (var i = 0; i < friends.length; i++) {
                for (var key in friends[i]) {
                    if (col.indexOf(key) === -1) {
                        col.push(key);
                    }
                }
            }

            // The conversion form json to table is based on the code found on https://www.encodedna.com/javascript/populate-json-data-to-html-table-using-javascript.htm

            // CREATE DYNAMIC TABLE.
            var table = document.createElement("table");

            // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

            var tr = table.insertRow(-1);// TABLE ROW.
            var th = document.createElement("th");
            th.innerHTML = "Name";
            tr.appendChild(th);
            var th = document.createElement("th");
            th.innerHTML = "Status";
            tr.appendChild(th);
            /**for (var i = 0; i < col.length; i++) {
                var th = document.createElement("th");      // TABLE HEADER.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }**/

            // ADD JSON DATA TO THE TABLE AS ROWS.
            for (var i = 0; i < friends.length; i++) {

                tr = table.insertRow(-1);

                var td = tr.insertCell(-1);
                td.innerHTML = friends[i][col[0]];
                td.addEventListener("click", function() {
                    chatWith(this.innerHTML);
                });

                td = tr.insertCell(-1);
                td.innerHTML = friends[i][col[1]];

                /*for (var j = 0; j < col.length; j++) {
                    var tabCell = tr.insertCell(-1);
                    tabCell.innerHTML = friends[i][col[j]];
                    tabCell.addEventListener("click", function() {
                        alert(this.id);
                    });
                }*/
            }

            // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
            var divContainer = document.getElementById("friends");
            divContainer.innerHTML = "";
            divContainer.appendChild(table);

            setTimeout(getFriends, 2000);
        }
    }

}