package com.kodilla.spring.extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 1, 5, 6, 4));
        ArrayList<Integer> sortedList = sortNumbers(numbers);
        System.out.println(sortedList);
    }

    private static ArrayList<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return new ArrayList<>(numbers);
    }


}
