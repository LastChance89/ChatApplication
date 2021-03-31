import {User} from './user.js';
import {setupAjax} from './setup.js';



$("#submit").on("click",createAccount);
$("#login").on("click",login);

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

    $(document).ready(()=>{
        setupAjax("http://localhost:8080/createAccount", user);
        $.ajax().then((data)=>{
            console.log(data);
        })
    });

}

function login(e){
    e.preventDefault();
    let creds = {"creds": [$("#nameInput").val(),$("#password").val()]};
    $(document).ready(()=>{
        setupAjax("http://localhost:8080/login", creds);
        $.ajax().then((data)=>{
            if(data !== undefined && data!== null){
                window.location.href = '../templates/chat.html';
            }            
            else{
                console.log("DOH");
            }
        });
    });
}


