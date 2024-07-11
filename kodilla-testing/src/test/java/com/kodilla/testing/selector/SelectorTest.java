package com.kodilla.testing.selector;

import com.kodilla.testing.selector.exception.DuplicateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SelectorTest {

    private Selector selector = new Selector();
    private int duplicate;
    @BeforeEach
    void setUp() {
        duplicate = 0;
    }

    @Test
    void testSelectorListWithoutDuplicate() {
        //Given
        List<Integer> listToCheck = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //When
        try {
            selector.searchDuplicate(listToCheck);
        } catch (DuplicateException e) {
            //do nothing
        }
        //Then
        assertThrows(DuplicateException.class, () -> selector.searchDuplicate(listToCheck));
    }

    @Test
    void testSelectorListWithDuplicate() {
        //Given
        List<Integer> listToCheck = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 4);
        //When
        try {
            duplicate = selector.searchDuplicate(listToCheck);
        } catch (DuplicateException e) {
            //do nothing
        }
        //Then
        assertEquals(4, duplicate);
    }

    @Test
    void testSelectorListWithTwoDuplicates() {
        //Given
        List<Integer> listToCheck = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 7);
        //When
        try {
            duplicate = selector.searchDuplicate(listToCheck);
        } catch (DuplicateException e) {
            //do nothing
        }
        assertThrows(DuplicateException.class, () -> selector.searchDuplicate(listToCheck));
    }

}