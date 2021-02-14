
var client = null;



function init(){
    let socket = new SockJS('/webSocket')
    client = Stomp.over(socket);
    client.connect({},  (frame)=>{
        console.log('Connected');
        //This subscribes to our backend sendTo on the controller.
        client.subscribe('/messsage',  (greeting)=>{
            testMe(greeting);
        })
    })

//event listener adders 
document.getElementById("fire").addEventListener("click", makeCall,false);

function makeCall(e){
    e.preventDefault();
    client.send("/app/sendMessage",{}, JSON.stringify({'userName': document.getElementById('username').value,'message':document.getElementById('input').value}));
    document.getElementById('input').value='';
}

function testMe(response){

    let returnedResponse = JSON.parse(response.body);
    
    if(returnedResponse.userName ==  document.getElementById('username').value){
        document.getElementById('responsArea').innerHTML +=  "<br> <p class='current-user'>" + returnedResponse.userName +": "+ returnedResponse.message + "</p>";
    }
    else{
        document.getElementById('responsArea').innerHTML +=  "<br> <p>" + returnedResponse.userName +": "+ returnedResponse.message + "</p>";
    }
}


}
