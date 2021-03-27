import {User} from './user.js';
import {setupAjax} from './setup.js';



$("#submit").on("click",createAccount);

function createAccount(e){
    e.preventDefault();
    let createdDate = new Date().toLocaleDateString('fr-CA',
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