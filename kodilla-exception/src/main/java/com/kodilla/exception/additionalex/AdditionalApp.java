package com.kodilla.exception.additionalex;

public class AdditionalApp {
    public static void main(String[] args) {
        Exponentiation exponentiator = new Exponentiation();
        int poweredNumber = exponentiator.powerTheNumber(10, 3);
        System.out.println(poweredNumber);
    }
}
