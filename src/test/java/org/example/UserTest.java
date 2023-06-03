package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("패스워드 초기화")
    @Test
    void passwordTest(){
        //given
        User user = new User();

        //when
        //user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "aabbccdd");
        /*램덤으로 값이 만들어져 결과값이 성공 또는 실패했었다.
        값에 CorrectFixedPasswordGenerator 추가하며 일정한 값이 들어와 결과값도 동일하다.*/

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2(){
        //given
        User user = new User();

        //when
        //user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(()->"abc");

        //then
        assertThat(user.getPassword()).isNull();
    }
}