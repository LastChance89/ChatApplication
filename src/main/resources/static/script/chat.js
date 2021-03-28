import {User} from './user.js';
import {setupAjax} from './setup.js';

var client = null;

$("#login").on("click",login);



function init() {
    let socket = new SockJS('/webSocket')
    client = Stomp.over(socket);
    client.connect({}, (frame) => {
        console.log('Connected');
        //This subscribes to our backend sendTo on the controller.
        client.subscribe('/messsage', (response) => {
            updateText(response);
        })
    })

    $("#fire").on("click",makeCall);

    
    function makeCall(e) {
        e.preventDefault();
        client.send("/app/sendMessage", {}, JSON.stringify({ 'userName': document.getElementById('username').value, 'message': document.getElementById('input').value }));
        document.getElementById('input').value = '';
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
}


function setButtonDisabled() {
    document.getElementById("fire").disabled = document.getElementById("input").value != "" ? false : true;

}

function login(e){
    e.preventDefault();
    let creds = {"creds": [$("#nameInput").val(),$("#password").val()]};
    $(document).ready(function(){
        setupAjax("http://localhost:8080/login", creds);
        $.ajax().then((data)=>{
            console.log(data);
        });
    });
}