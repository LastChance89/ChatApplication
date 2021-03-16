import {User} from './user.js';
import {setupAjax} from './setup.js';

document.getElementById("submit").addEventListener("click", createAccount, false);

function createAccount(e){
    e.preventDefault();
    let createdDate = new Date().toLocaleDateString('en-US',
    {
        year:'numeric',
        day: 'numeric',
        month: 'numeric'
    });
    let user = new User($("#Username").val(), $("#password").val(),$("#email").val(),
    $("#hint").val(),createdDate,"enabled");

    $(document).ready(function(){
        setupAjax("http://localhost:8080/createAccount", user);
        $.ajax().then((data)=>{
            console.log(data);
        })


    });

}