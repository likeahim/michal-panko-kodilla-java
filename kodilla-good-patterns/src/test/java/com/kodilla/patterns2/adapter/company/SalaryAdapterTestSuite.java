package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        // Given
        Workers workers = new Workers();                      // [1]
        SalaryAdapter salaryAdapter = new SalaryAdapter();    // [2]
        // When
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());   // [3]
        // Then
        System.out.println(totalSalary);
        assertEquals(27750, totalSalary, 0);                  // [4]
    }
}