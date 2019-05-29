window.onload = pE;

var xHRObjectPE = new XMLHttpRequest();
var xHRObjectAddPE = new XMLHttpRequest();


function addPE() {
    var pEDate = document.getElementById("PEDate").value;
    var pETitle = document.getElementById("PETitle").value;
    var pEYear = document.getElementById("PEYear").value;
    var information = "date=" + encodeURIComponent(pEDate) + "&title=" + encodeURIComponent(pETitle) + "&year="+ encodeURIComponent(pEYear);
    xHRObjectAddPE.open("POST", "Controller?async=AddPraktijkExamen", true);
    xHRObjectAddPE.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRObjectAddPE.send(information);
}

function pE(){
    getPE();
}

function getPE() {
    xHRObjectPE.open("GET", "Controller?async=GetPraktijkExamens", true);
    xHRObjectPE.onreadystatechange = getDataPE;
    xHRObjectPE.send(null);
}


function getDataPE () {
    if (xHRObjectPE.status === 200) {
        if (xHRObjectPE.readyState === 4) {
            var serverResponse = JSON.parse(xHRObjectPE.responseText);
            var list = serverResponse;

            var col = [];
            for (var i = 0; i < list.length; i++) {
                for (var key in list[i]) {
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
            th.innerHTML = "Datea";
            tr.appendChild(th);
            var th = document.createElement("th");
            th.innerHTML = "Title";
            tr.appendChild(th);
            var th = document.createElement("th");
            th.innerHTML = "Year";
            tr.appendChild(th);
            /**for (var i = 0; i < col.length; i++) {
                var th = document.createElement("th");      // TABLE HEADER.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }**/

            // ADD JSON DATA TO THE TABLE AS ROWS.
            for (var i = 0; i < list.length; i++) {

                tr = table.insertRow(-1);

                var td = tr.insertCell(-1);
                td.innerHTML = list[i][col[0]];

                td = tr.insertCell(-1);
                td.innerHTML = list[i][col[1]];

                td = tr.insertCell(-1);
                td.innerHTML = list[i][col[2]];

                /*for (var j = 0; j < col.length; j++) {
                    var tabCell = tr.insertCell(-1);
                    tabCell.innerHTML = friends[i][col[j]];
                    tabCell.addEventListener("click", function() {
                        alert(this.id);
                    });
                }*/
            }

            // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
            var divContainer = document.getElementById("PE");
            divContainer.innerHTML = "";
            divContainer.appendChild(table);

            setTimeout(getPE, 1500 );
        }
    }

}
