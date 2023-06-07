package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
* 요구사항
* 간단한 사칙연산 수행
* 양수로만 계산
* 나눗셈에서 0으로 나누는 경우 IllegalArgument 예외를 발생
* MVC패턴 기반으로 구현
*/
public class CalculatorTest {
    /*
    * 1 + 2 → Calculator 계산을 하는 인터페이스 구현
    * 3     ← 결과값 반환
    */
    /*
    @DisplayName("덧셈 연산을 수행")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행")
    @Test
    void additionTest2() {
        int result = Calculator.calculate(2, "-", 1);
        assertThat(result).isEqualTo(1);
    }
    */
    /* --- */

    @DisplayName("연산을 수행")
    @ParameterizedTest
    @MethodSource("formulaAndResult") //아래의 소스를 가져와서 사용한다.
    void additionTest3(int operand1, String operator, int operand2, int result) {
        //int calculateResult = Calculator.calculate(operand1, operator, operand2);
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1, "+", 2, 3)
                , arguments(2, "-", 1, 1)
                , arguments(2, "*", 1, 2)
                , arguments(4, "/", 2, 2)
        );
    }

    /* --- */
    @DisplayName("나눗셈에서 0으로 나누는 경우 IllegalArgument 발생")
    @Test
    void calculateExceptionTest(){
        assertThatCode(() -> Calculator.calculate(10, "/", 0))
                .isInstanceOf(IllegalArgumentException.class)//해당 오류가 발생
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    /* --- */

    @DisplayName("나눗셈에서 0으로 나누는 경우 IllegalArgument 발생")
    @Test
    void calculateExceptionTest2(){
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)//해당 오류가 발생
                .hasMessage("0으로 나눌 수 없습니다.");
    }

}
