var client = null;


$(document).ready(() => {
    //call our init function to subscribe to our various work. 
    init();

    //setup our bindings
    $("#input").on("keyup", setButtonDisabled);
    //Make sure that when we submit we dont move to next page 
    //and then we call our method to make the call to back end
    $("#form").on("submit", (e) => {
        e.preventDefault();
        makeCall();
    })

});


function init() {
    let socket = new SockJS('/webSocket')
    client = Stomp.over(socket);
    client.connect({}, (frame) => {
        console.log('Connected');
        //This subscribes to our backend sendTo on the controller.
        client.subscribe('/messsage', (response) => {
            updateText(response);
        });
    });
}


function makeCall() {
    client.send("/app/sendMessage", {}, JSON.stringify({ 'userName': document.getElementById('username').value, 'message': document.getElementById('input').value }));
    document.getElementById('input').value = '';
    document.getElementById("fire").disabled = true;
}


function updateText(response) {
    let returnedResponse = JSON.parse(response.body);
    if (returnedResponse.userName == document.getElementById('username').value) {
        document.getElementById('responsArea').innerHTML += "<p class='current-user'>" + returnedResponse.message + "</p>";
    }
    else {
        document.getElementById('responsArea').innerHTML += "<p>" + returnedResponse.userName + ": " + returnedResponse.message + "</p>";
    }
}

function setButtonDisabled() {
    document.getElementById("fire").disabled = document.getElementById("input").value != "" ? false : true;

}