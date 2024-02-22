package com.kodilla.exception.additionalex;

public class Exponentiation {
    public int powerTheNumber(int number, int power) {
        int result;
        if (number == 0) return 0;
        if (power == 0) return 1;
        if (power == 1) return number;
        else {
            result = number;
            for (int i = 1; i < power; i++) {
                result = result * number;
            }
        }
        return result;
    }
}
