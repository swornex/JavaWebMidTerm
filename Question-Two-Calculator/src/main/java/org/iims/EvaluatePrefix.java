package org.iims;

import java.util.Stack;

public class EvaluatePrefix {
    static Stack<Double> stack = new Stack<>();

    static void calculate(Double firstNumber, Double secondNumber, String operator) {
        switch (operator) {
            case "+":
                stack.push(firstNumber + secondNumber);
                break;
            case "-":
                stack.push(firstNumber - secondNumber);
                break;
            case "*":
                stack.push(firstNumber * secondNumber);
                break;
            case "/":
                stack.push(firstNumber / secondNumber);
                break;
        }
    }


    public static double evaluatePrefix(String expression) {
        String[] numberOperator = expression.split("\\s+");

        for (int i = numberOperator.length - 1; i >= 0; i--) {
            if (isDigit(numberOperator[i].charAt(0))) {
                stack.push(Double.parseDouble(numberOperator[i]));
            } else {
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();

                calculate(firstNumber, secondNumber, numberOperator[i]);
            }
        }

        return stack.peek();
    }

    static Boolean isDigit(char numOp) {
        return numOp >= 48 && numOp <= 57;
    }


}


