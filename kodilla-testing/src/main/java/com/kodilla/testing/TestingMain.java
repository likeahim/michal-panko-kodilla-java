package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;
        int addResult = calculator.add(a, b);
        int subtResult = calculator.subtract(a, b);
        if(a + b == addResult)
            System.out.println("adding test ok");
        else
            System.out.println("adding method error");

        if(a - b == subtResult)
            System.out.println("subtracting test ok");
        else
            System.out.println("subtracting method error");
    }
}
