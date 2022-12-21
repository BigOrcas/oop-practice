package org.example.passwordvalidation;

import org.example.passwordvalidation.PasswordGenerator;

public class WrongPasswordGenerator implements PasswordGenerator {

    @Override
    public  String generatePassword(){
        return  "ab"; // 2글자
    }
}
