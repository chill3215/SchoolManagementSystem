package com.lechi.managementsystem.Service;

import java.security.SecureRandom;

public class RandomPasswordGenerator {

    private static final String CHARACTERS ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";

    private static final int PASSWORTLENGTH = 12;

    public static String generatePassword(){
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORTLENGTH);
        for (int i = 0; i < PASSWORTLENGTH; i++) {
            int charIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(charIndex));
        }
        return password.toString();
    }
}
