package org.example.calculate;

public interface NewArithmeticOperator {
    /* 리팩토링 2 */
    boolean supports(String operator); //제공하는지 확인한다.
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
