package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    /* 리팩토링 1 */
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }
    , SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }
    , MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }
    , DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator){
        this.operator = operator;
    }

    public static int calculate(int operand1, String operator, int operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())// 모든 인자값을 가지고 온다.
                .filter(v -> v.operator.equals(operator))// operator 검색
                .findFirst()//같은 것을 가지고 온다.
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));//사칙연산을 찾지 못한 경우 오류를 발생시킨다.

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

}
