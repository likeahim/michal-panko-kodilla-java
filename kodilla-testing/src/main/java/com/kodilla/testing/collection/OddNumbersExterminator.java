package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> equalsNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 == 0)
                equalsNumbers.add(number);
        }
        return equalsNumbers;
    }
}
