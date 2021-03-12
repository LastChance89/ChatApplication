import {User} from './user.js';


document.getElementById("submit").addEventListener("click", createAccount, false);

function createAccount(e){
    e.preventDefault();
    let createdDate = new Date().toLocaleDateString('en-US',
    {
        year:'numeric',
        day: 'numeric',
        month: 'numeric'
    });
    let user = new User($("#Username").val(), $("#password").val(),$("email").val(),
    $("hint").val(),createdDate,"enabled");
}