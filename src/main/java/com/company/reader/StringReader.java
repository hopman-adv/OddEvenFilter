package com.company.reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reader for file input.
 */
public class StringReader implements Reader {
    private String inputString;

    /**
     * Class constructor.
     */
    public StringReader() {
    }

    /**
     * Class constructor with specified inputString.
     * @param inputString Input string which should be read.
     */
    public StringReader(String inputString) {
        this.inputString = inputString;
    }

    /**
     * Sets input string for instance.
     * @param inputString Input String which should be read.
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    /**
     * Gets all positive/zero Integer values from provided String.
     * Skips all incorrect characters (letters, negative values, non-integers).
     * Writes message to console for incorrect characters.
     * @return List of non-negative Integers.
     */
    @Override
    public List<Integer> getInput() {
        return Arrays.stream(inputString.split(" "))
                .filter(this::isInteger)
                .map(Integer::valueOf)
                .filter(this::isPositive)
                .collect(Collectors.toList());
    }
}
