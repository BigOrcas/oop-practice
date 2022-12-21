package org.example.passwordvalidation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드 초기화 여부 판단. 흔들리는 꽃들 속에서 네 샴푸향이 느껴진거야")
    @Test
    void passwordTest(){
        // given 유저 객체 생성
        User user = new User();

        // when 해당 메소드 호출
        user.initPassword(()-> "abcdefgh"); // 이런 식의 함수형 프로그래밍도 가능?하네 자바 개쩌네

        // then
        assertThat(user.getPassword()).isNotNull();
    }
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화 되지 않는다. 너가 뭔데 내꺼 통과안시켜?")
    @Test
    void passwordTest2(){
        // given 유저 객체 생성
        User user = new User();

        // when 해당 메소드 호출
        user.initPassword(new WrongPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNull();

    }
}
