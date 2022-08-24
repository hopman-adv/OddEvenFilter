package com.company.filter;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.enums.Messages.EMPTY_LIST;


/**
 * Filters values by their count.
 */
public class Filter {
    private List<Integer> input;

    /**
     * Class constructor.
     */
    public Filter() {
    }

    /**
     * Class constructor with specified list.
     * @param input List of non-negative numbers.
     */
    public Filter(List<Integer> input) {
        this.input = input;
    }

    /**
     * @return List of non-negative numbers.
     */
    public List<Integer> getInput() {
        return input;
    }

    /**
     * Sets input for this instance.
     * @param input List of non-negative numbers.
     */
    public void setInput(List<Integer> input) {
        this.input = input;
    }

    /**
     * Counts number of integers in input List.
     * @return Count of numbers in input List.
     */
    private int getNumbersCount() {
        return getInput().size();
    }

    /**
     * Checks if numbers count is odd or even.
     * @return true for odd count and false for even count.
     */
    private boolean isCountOdd() {
        return getNumbersCount() % 2 != 0;
    }

    /**
     * Takes number and returns boolean if it is odd.
     * @param number Integer.
     * @return True for odd number, false for even.
     */
    private boolean isNumberOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * Filters input List by count of elements.
     * Odd count of elements filters only odd numbers from list.
     * Even count of elements filters only even numbers from list.
     * Empty list exits application.
     * @return List of filtered integers depending on their count.
     */
    public List<Integer> filterNumbers() {
        if(input.size() == 0) {
            System.out.println(EMPTY_LIST.getMessage());
            System.exit(0);
        }
        return getInput().stream()
                .filter(i -> isCountOdd() == isNumberOdd(i))
                .collect(Collectors.toList());
    }
}
