package com.company.test;

import com.company.filter.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    Filter filter;

    @BeforeEach
    void setUp() {
        filter = new Filter();
    }

    @Test
    void filterEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 1, 2, 1, 2);
        filter.setInput(numbers);

        List<Integer> evenNumbers = filter.filterNumbers();
        System.out.println(evenNumbers);
        assertEquals(evenNumbers, List.of(2, 2, 2));
    }

    @Test
    void filterOddNumbers() {
        List<Integer> numbers = List.of(1, 2, 1, 2, 1);
        filter.setInput(numbers);

        List<Integer> oddNumbers = filter.filterNumbers();
        System.out.println(oddNumbers);
        assertEquals(oddNumbers, List.of(1, 1, 1));
    }
}