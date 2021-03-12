class User{
    constructor(username, password, email, hint, createdDate, status ){
        this.username = username; 
        this.password = password; 
        this.createdDate = createdDate; 
        //this.passwordExp = passwordExp; Not sure where I want to set this yet. 
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

export {User};
