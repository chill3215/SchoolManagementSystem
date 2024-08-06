package com.lechi.managementsystem.Model.Enum;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NOT_SPECIFIED("Not specified");

    private final String displayName;


    Gender(String displayName) {
        this.displayName=displayName;
    }


}
