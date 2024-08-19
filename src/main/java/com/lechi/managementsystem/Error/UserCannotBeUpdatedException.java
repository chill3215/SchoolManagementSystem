package com.lechi.managementsystem.Error;

public class UserCannotBeUpdatedException extends CustomException{
    public UserCannotBeUpdatedException(String explanation, String instruction) {
        super("User cannot be updated", explanation, instruction);
    }
}
