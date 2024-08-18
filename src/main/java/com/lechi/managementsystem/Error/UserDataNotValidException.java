package com.lechi.managementsystem.Error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDataNotValidException extends CustomException{

    public UserDataNotValidException(String explanation, String instruction) {
        super("User's data is not valid", explanation, instruction);
    }
}
