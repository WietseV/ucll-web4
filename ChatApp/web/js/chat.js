var currentId = null;
var interval = null;

function closeChat(){
    $("#chat").hide();
    clearInterval(interval);
}

function chatWith(id) {
    currentId = id;
    interval = setInterval(getChatText, 750);
    $("#chat").hide();
    $("#chat").show();
    $("#id").text(id);
}

function sendMessage(id) {
    id=currentId;
    var msg = $('#msg').val();
    $('#msg').val("");
    $.post("Controller", {async: "SendMsg", message: msg, userId: id})

}

function getChatText() {
    if (currentId !== "") {
        $.ajax({
            type: "GET",
            url: "Controller?async=GetChat&userName=" + currentId,
            dataType: "text json",
            success: function (result) {
                $('#chatText').empty();
                for (var i = 0; i < result.length; i++) {
                    $('#chatText').append($('<li>' + result[i]+ '</li>'));
                }
            },
            error: function () {
                console.log('error');
            }
        })
    }

}