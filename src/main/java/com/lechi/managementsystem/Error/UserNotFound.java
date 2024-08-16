package com.lechi.managementsystem.Error;

public class UserNotFound extends Exception{

    public UserNotFound(){
        super();
    }

    public UserNotFound(String msg){
        super(msg);
    }
}
