package com.kodilla.testing.selector;

import com.kodilla.testing.selector.exception.DuplicateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Selector {

    public int searchDuplicate(List<Integer> numbers) throws DuplicateException {
        int duplicate = 0;
        List<Integer> sortedList = sortList(numbers);
        if (sortedList.get(0) != 1)
            throw new IllegalStateException("Number must be 1");
        for (int i = 0; i < sortedList.size() - 2; i++) {
            if (sortedList.get(i) == sortedList.get(i + 1) && duplicate == 0) {
                duplicate = sortedList.get(i);
            } else if (sortedList.get(i) == sortedList.get(i + 1) && duplicate != 0)
                throw new DuplicateException("to much duplicates");
        }
        if (duplicate == 0) {
            throw new DuplicateException("no duplicate in list");
        }
        return duplicate;
    }

    private List<Integer> sortList(List<Integer> numbers) {
        ArrayList<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted;
    }
}
