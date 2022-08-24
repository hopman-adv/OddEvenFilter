package com.company.printer;

import java.util.List;

/**
 * Printer for specific output.
 */
public interface Printer {
    /**
     * Sets input list of numbers which should be printed.
     * @param list List of integers.
     */
    void setList(List<Integer> list);

    /**
     * Prints result from list to specified output.
     */
    void printResult();
}
