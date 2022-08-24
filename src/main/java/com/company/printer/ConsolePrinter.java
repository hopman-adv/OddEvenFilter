package com.company.printer;

import java.util.List;

/**
 * Printer for printing into console.
 */
public class ConsolePrinter implements Printer {
    private List<Integer> list;

    /**
     * Class constructor.
     */
    public ConsolePrinter() {
    }

    /**
     * Sets input list of numbers which should be printed.
     * @param list List of integers.
     */
    public void setList(List<Integer> list) {
        this.list = list;
    }

    /**
     * Prints input list into console.
     */
    public void printResult() {
        System.out.println(list);
    }
}
