package org.example.passwordvalidation;

import org.example.passwordvalidation.PasswordGenerator;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){ // 상위에 인터페이스를 만들어 결합도를 낮추었다
        // as -is
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); // 내부에서 생성을 했기 때문에 결합도가 높아진다

        // to -be
        String password = passwordGenerator.generatePassword();
        /**
         *  비밀번호는 최소 8자 이상 12자 이하여야한다.
         */
        if(password.length()>=8 && password.length()<=12){
            this.password =password;
        }


    }

    public String getPassword(){
        return password;
    }
}
