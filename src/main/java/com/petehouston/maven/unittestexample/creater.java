package com.petehouston.maven.unittestexample;

public class creater {
    public creater() {
        throw new UnsupportedOperationException("Cannot call constructor directly!");
    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero (0).");
        }
        return dividend / divisor;
    }
    private void tuan(){

    }
    public static int add(int number1, int number2) {
        return number1 + number2;
    }


}
