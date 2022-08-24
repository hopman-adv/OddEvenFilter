package com.company.test;

import com.company.reader.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    void createFileReader() {
        fileReader = new FileReader();
    }

    @Test
    void getInputOnlyIntegers() {
        fileReader.setFilepath("src/test/resources/testNormal.txt");
        List<Integer> expected = List.of(0, 12, 12, 12, 12, 12, 12, 12, 1, 2, 1, 2147483647, 2234);

        assertEquals(fileReader.getInput(), expected);
    }

    @Test
    void getInputEmpty() {
        fileReader.setFilepath("src/test/resources/testEmpty.txt");
        List<Integer> expected = List.of();

        assertEquals(fileReader.getInput(), expected);
    }

    @Test
    void getInputLarge() {
        fileReader.setFilepath("src/test/resources/testLargeNum.txt");
        List<Integer> expected = List.of(21212121, 2234, 5632, 56, 65, 43);

        assertEquals(fileReader.getInput(), expected);
    }

    @Test
    void getInputLetters() {
        fileReader.setFilepath("src/test/resources/testLetters.txt");
        List<Integer> expected = List.of(12, 2234, 5632, 355334, 56);

        assertEquals(fileReader.getInput(), expected);
    }

    @Test
    void getInputNegative() {
        fileReader.setFilepath("src/test/resources/testNegative.txt");
        List<Integer> expected = List.of(0, 12, 2234);

        assertEquals(fileReader.getInput(), expected);
    }

}