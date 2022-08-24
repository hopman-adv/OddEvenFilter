package com.company.test;

import com.company.reader.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringReaderTest {

    private StringReader stringReader;

    @BeforeEach
    void createReader() {
        stringReader = new StringReader();
    }

    @Test
    void getInputIntegers() {
        stringReader.setInputString("0 1 22 13 2147483647");
        List<Integer> expectedList = List.of(0, 1, 22, 13, 2147483647);

        assertEquals(stringReader.getInput(), expectedList);
    }

    @Test
    void getInputLetters() {
        stringReader.setInputString("1 B 13");
        List<Integer> expectedList = List.of(1, 13);

        assertEquals(stringReader.getInput(), expectedList);
    }

    @Test
    void getInputLarge() {
        stringReader.setInputString("1 22 2147483648");
        List<Integer> expectedList = List.of(1, 22);

        assertEquals(expectedList, stringReader.getInput());
    }

    @Test
    void getInputNegative() {
        stringReader.setInputString("-2147483647 -1 0 1 22");
        List<Integer> expectedList = List.of(0, 1, 22);

        assertEquals(expectedList, stringReader.getInput());
    }
}