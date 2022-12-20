package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;


/**
 * • 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * • 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생
 * 시킨다.
 * • 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest  {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지않는다. 너가 뭔데?")
    @Test
    void validatePasswordTest(){
        assertThatCode(()->PasswordValidator.validate("bigwhale18"))
                .doesNotThrowAnyException();
    }
    
    // 경계조건을 테스트한다
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.") // 테스트 후 무엇을 테스트 했는지 명시해준다
    @ParameterizedTest // 여러 argument를 이용해 테스트를 여러번 돌릴 수 있는 테스트를 할 수 있는 기능 제공
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"}) // argument를 전달해준느 기능
    void validatePasswordTest2(String password) {
        // given
        //PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> PasswordValidator.validate(password)) // 예외가 던져지지 않아도 as()의 설명이 에러 메세지에 나타고 실패하지 않는다
                .isInstanceOf(IllegalArgumentException.class) // 던져진 에러의 인스턴스 타입을 지정할 수 있다
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다."); // 에러 메세지에 관한 테스트를 추가할 수 있다
    }



}
