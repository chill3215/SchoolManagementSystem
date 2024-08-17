package com.lechi.managementsystem.Error;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
public class UserCannotBeAddedException extends CustomException{

    public UserCannotBeAddedException(String explanation, String instruction) {
        super("User cannot be added", explanation, instruction);
    }

}
