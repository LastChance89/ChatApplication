class User{
    constructor(username, password, createdDate, passwordExp, hint, email, status ){
        this.username = username; 
        this.password = password; 
        this.createdDate = createdDate; 
        this.passwordExp = passwordExp;
        this.hint = hint; 
        this.email = email;
        this.status = status;
    }

    getUserName(){
        return this.username;
    }
    getPasswordExp(){
        return this.passwordExp;
    }
    getHint(){
        return this.hint;
    }
    
    

}


