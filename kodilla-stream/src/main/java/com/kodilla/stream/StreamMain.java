package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Lambda expressions calculating:");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Methods reference calculating:");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAbyB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

        PoemBeautifier beautifier = new PoemBeautifier();
        String thisIsWhatItIs = "this is what it is";
        String def = "def";
        String wordToDiscover = "XXX yoX beaXtifXl";
        String uglyWord = "    XlphXbE  t   i cX  l   ";

        String thisIsWhatItIsAfter = beautifier.beautify(thisIsWhatItIs,
                stringToDecorate -> stringToDecorate.toUpperCase());
        String defAfter = beautifier.beautify(def, (stringToDecorate -> "ABC" + stringToDecorate + "GHI"));
        String wordToDiscoverAfter = beautifier.beautify(wordToDiscover,
                (stringToDecorate -> stringToDecorate.replace('X', 'u')));
        String beautyWord = beautifier.beautify(uglyWord, StreamMain::makeItBeauty);

        showChange(thisIsWhatItIs, thisIsWhatItIsAfter);
        showChange(def, defAfter);
        showChange(wordToDiscover, wordToDiscoverAfter);
        showChange(uglyWord, beautyWord);
    }


    private static void showChange(String origin, String after) {
        System.out.println("String before changes: " + origin);
        System.out.println("String after changes: " + after);
    }

    private static String makeItBeauty(String uglyString) {
        String beautyString = uglyString;
        beautyString = beautyString.trim()
                .toLowerCase()
                .replaceAll("x", "a")
                .replaceAll(" ", "");
        return beautyString;
    }
}

