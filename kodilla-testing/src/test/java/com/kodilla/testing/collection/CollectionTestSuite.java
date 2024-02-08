package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case end");
    }
    @DisplayName(
            "when odds numbers exterminated from given list, " +
                    "then returned list should be empty"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {

        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> exterminateList = exterminator.exterminate(exterminator.getNumbers());
        Assertions.assertEquals(0, exterminateList.size());
    }

    @DisplayName(
            "when given list contains odds and equals numbers" +
                    "then should passes the test"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        int odds = 0;
        int equals = 0;
        for (Integer number : exterminator.getNumbers()) {
            if(number % 2 == 0)
                equals = 1;
            else if (number % 2 != 0)
                odds = 1;
        }
        Assertions.assertTrue(odds == equals);
    }
}
