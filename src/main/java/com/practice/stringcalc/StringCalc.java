package com.practice.stringcalc;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class StringCalc {
    public void proceed() {
        Scanner scanner = new Scanner(System.in);
        int result;
        try {
            result = getResult(scanner.nextLine());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception is occurred : " + e.getMessage());
        }
    }

    int getResult(String input) throws IllegalArgumentException, ArithmeticException {
        String[] values = input.split(" ");
        int result = 0;
        String operator = "";
        for (String v : values) {
            if (isOperator(v)) {
                operator = v;
                continue;
            }
            result = calculate(result, operator, v);
            operator = "";
        }
        return result;
    }

    int calculate(int result, String operator, String v) throws IllegalArgumentException {
        int num = Integer.parseInt(v);
        switch (operator) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                result /= num;
                break;
            case "%":
                result %= num;
                break;
            case "":
                if (result == 0) {
                    result = num;
                    break;
                }
                // FALL-THROUGH
            default:
                throw new IllegalArgumentException("Unknown operator : " + operator);
        }
        return result;
    }

    boolean isOperator(String v) {
        return v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/") || v.equals("%");
    }

}
