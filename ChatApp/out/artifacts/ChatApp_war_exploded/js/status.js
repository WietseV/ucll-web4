window.onload = getCurrentStatus;

var xHRObject = new XMLHttpRequest();
var updateStatusRequest = new XMLHttpRequest();

function updateStatus () {
    var statusText = document.getElementById("statustext").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    var information = "status=" + encodeURIComponent(statusText);
    updateStatusRequest.open("POST", "Controller?async=UpdateStatus", true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    updateStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    updateStatusRequest.send(information);
}

function getCurrentStatus () {
    xHRObject.open("GET", "Controller?async=GetStatus", true);
    xHRObject.onreadystatechange = getData;
    xHRObject.send(null);
}

function getData () {
    if (xHRObject.status == 200) {
        if (xHRObject.readyState == 4) {
            alert(xHRObject.responseText);
            var serverResponse = JSON.parse(xHRObject.responseText);
            var status = serverResponse.status; // of je kan ook doen: serverResponse["status"]
            //var status = xHRObject.responseText;
            var statusDiv = document.getElementById("status");
            var statusParagraph = statusDiv.childNodes[0];
            if (statusParagraph == null) {
                statusParagraph = document.createElement('p');
                statusParagraph.id = "statusText";
                var statusText = document.createTextNode(status);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }
            else {
                var statusText = document.createTextNode(status);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }/**
            var div = document.getElementById("status");
            var p = document.createElement("p");
            alert("toch iets");
            alert(xHRObject.responseText);
            var text = document.createTextNode(xHRObject.responseText);
            alert(xHRObject.responseText);
            p.appendChild(text);
            div.appendChild(p);**/
            setTimeout(getCurrentStatus, 3000);
        }
    }
}