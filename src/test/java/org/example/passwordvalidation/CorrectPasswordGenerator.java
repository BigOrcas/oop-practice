package org.example.passwordvalidation;

import org.example.passwordvalidation.PasswordGenerator;

public class CorrectPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword(){
        return "abcdefgh"; // 8글자
    }
}
