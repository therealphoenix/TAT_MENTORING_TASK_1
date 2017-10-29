package com.klindziuk.mentoring.calculator;

import java.util.ArrayList;

/**
 * Created by Hp on 28/10/2017.
 */

public class CommandLineCalculator {

    private CommandLineCalculator() {
    }

    public static float calculate(String[] args) {
        String[] expression = checkArgs(args);

        float firstNumber = Float.parseFloat(expression[0]);
        float secondNumber = Float.parseFloat(expression[2]);
        String operation = expression[1];

        switch (operation) {
            case "+":
                return (firstNumber + secondNumber);
            case "-":
                return (firstNumber - secondNumber);
            case "*":
                return (firstNumber * secondNumber);
            case "/":
                return (firstNumber / secondNumber);
            default:
                throw new UnsupportedOperationException("\"Only + - * / operations are allowed\" ");
        }
    }

    private static String[] checkArgs(String[] args) {
        String[] expression = args[0].split(" ");

        if (expression.length != 3) {
            throw new IllegalArgumentException("Incorrect quantity of args");
        }
        return expression;
    }
}
