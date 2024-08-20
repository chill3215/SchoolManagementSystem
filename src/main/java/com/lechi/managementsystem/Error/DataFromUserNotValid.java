package com.lechi.managementsystem.Error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataFromUserNotValid extends CustomException{

    public DataFromUserNotValid(String explanation, String instruction) {
        super("Data from user is not valid", explanation, instruction);
    }
}
