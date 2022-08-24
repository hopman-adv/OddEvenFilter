package com.company.reader;

import java.util.List;

import static com.company.enums.Messages.PARSING_FAILED;
import static com.company.enums.Messages.SKIPPING_NEGATIVE;

/**
 * Reader of input values.
 */
public interface Reader {

    /**
     * Gets values from specific input and validates them.
     * @return List of Integers with valid values.
     */
    List<Integer> getInput();

    /**
     * Evaluates if input String is parse-able to Integer. Writes error message to console if String cannot be parsed.
     * @param number String which we want to check for parsing.
     * @return True for parse-able String and false for unparse-able.
     */
    default boolean isInteger(String number) {
        int intValue;
        try {
            intValue = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(PARSING_FAILED.getMessage() + number);
            return false;
        }
    }

    /**
     * Checks if Integer has positive/zero value. If not, writes message to console.
     * @param number any integer value.
     * @return True for 0 or positive values. False for negative.
     */
    default boolean isPositive(int number) {
        if (number < 0) {
            System.out.println(SKIPPING_NEGATIVE.getMessage() + number);
            return false;
        } else {
            return true;
        }
    }


}
