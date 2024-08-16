package com.lechi.managementsystem.Error;

public class UserAlreadyExists extends Exception{

    public UserAlreadyExists(){
        super();
    }

    public UserAlreadyExists(String msg){
        super(msg);
    }

    public UserAlreadyExists(String msg, Throwable cause){
        super(msg, cause);
    }


}
