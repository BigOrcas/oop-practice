package org.example.caculator;

import org.example.caculator.calculate.*;

import java.util.List;

public class Calculator {
    // 인터페이스를 통해 객체지향적으로 구현하기
    // 각각의 operator 구현체들을  상위 구현체인 arithmeticOperators을 통해 받는다
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(int operand1,String operator,int operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperators-> arithmeticOperators.supports(operator)) // 조건에 매치되는 필터를 적용한 것들을 리턴
                .map(arithmeticOperators->arithmeticOperators.calculate(operand1,operand2))// 선택 받은 operator들을 담아 전달
                .findFirst()// 필터 조건에 일치하는 요소 1개를 리턴
                .orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다")); // 찾지못한면 예외처리

    }
}
