package com.lechi.managementsystem.Error;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
public class CustomException extends Exception{

    private String exceptionName;

    private String explanation;

    private String instruction;

    public CustomException(String exceptionName, String explanation, String instruction) {
        this.exceptionName = exceptionName;
        this.explanation = explanation;
        this.instruction = instruction;
    }
}
