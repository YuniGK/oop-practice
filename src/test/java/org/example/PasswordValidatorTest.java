package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
* 비밀번호는 최소 8자 이상, 12자 이하
* 비밀번호가 8자 미만 또는 12자 초과 인 경우 IllegalArgumentException 예외를 발생
* 경계조건에 대해 테스트 코드 작성 ★★★
*/
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();//오류가 발생하지 않는다.
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과 인 경우 IllegalArgumentException 예외를 발생")
    @Test
    void validatePasswordTest2(){
        assertThatCode(() -> PasswordValidator.validate("abcd"))
                .isInstanceOf(IllegalArgumentException.class)//오류가 발생한다.
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과 인 경우 IllegalArgumentException 예외를 발생 - 경계값 테스트")
    @ParameterizedTest//데이터 등의 여러 소스를 이용해 테스트를 할 수 있다.
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})//7, 13 경계값에 대한 테스트
    void validatePasswordTest3(String password){
        assertThatCode(() -> PasswordValidator.validate("abcd"))
                .isInstanceOf(IllegalArgumentException.class)//오류가 발생한다.
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

}
