package com.company.runner;

import com.company.filter.Filter;
import com.company.printer.ConsolePrinter;
import com.company.printer.InFilePrinter;
import com.company.printer.Printer;
import com.company.reader.FileReader;
import com.company.reader.Reader;
import com.company.reader.StringReader;

import java.util.List;

import static com.company.enums.Messages.INCORRECT_PARAMETERS_COUNT;

/**
 * Runner for whole application.
 */
public class Runner {
    private Reader reader;
    private Printer printer;

    /**
     * Gets reader.
     * @return Reader.
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * Gets printer.
     * @return Printer.
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * Class constructor chooses reader and writer depending on type and number of arguments.
     * In case of incorrect number of arguments writes message into console and exits application.
     * @param args Arguments passed into console.
     */
    public Runner(String[] args) {
        int atrCount = args.length;

        if (atrCount == 1) {
            this.reader = getReader(args[0]);
            this.printer = new ConsolePrinter();
        } else if (atrCount == 2) {
            this.reader = getReader(args[0]);
            this.printer = new InFilePrinter(args[1]);
        } else {
            System.out.println(INCORRECT_PARAMETERS_COUNT.getMessage());
            System.exit(0);
        }
    }

    /**
     * Returns reader depending on parameter type.
     * @param parameter String parameter.
     * @return Reader depending on String parameter ending (".txt").
     */
    private Reader getReader(String parameter) {
        return parameter.endsWith(".txt") ? new FileReader(parameter) : new StringReader(parameter);
    }

    /**
     * Reads input, filters input and print it to file or console.
     */
    public void readFilterPrint() {
        List<Integer> input = reader.getInput();

        Filter filter = new Filter(input);
        List<Integer> list = filter.filterNumbers();

        printer.setList(list);
        printer.printResult();
    }
}
