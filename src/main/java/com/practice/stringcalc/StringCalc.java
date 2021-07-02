package com.practice.stringcalc;

import java.util.Scanner;

public class StringCalc {
    public void proceed() {
        Scanner scanner = new Scanner(System.in);
        int result;
        try {
            result = calculate(scanner.nextLine());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception is occurred : " + e.getMessage());
        }
    }

    int calculate(String input) throws NumberFormatException {
        String[] values = input.split(" ");
        int result = 0;
        for (String v : values) {
//            Element
        }
        return result;
    }

}
