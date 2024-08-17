package com.lechi.managementsystem.Error;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class UserNotFoundException extends CustomException{

    public UserNotFoundException(String explanation, String instruction){
        super("User cannot be found", explanation, instruction);
    }

}
