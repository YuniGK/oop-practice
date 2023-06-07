package org.example.calculate;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        /*
        PositiveNumber를 사용하고 있어 해당 부분을 필요가 없어졌다.
        if(operand2.toInt() == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        */

        return operand1.toInt() / operand2.toInt();
    }
}
