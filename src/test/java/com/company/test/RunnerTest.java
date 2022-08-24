package com.company.test;

import com.company.runner.Runner;
import com.company.printer.ConsolePrinter;
import com.company.printer.InFilePrinter;
import com.company.reader.FileReader;
import com.company.reader.StringReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void oneInputString() {
        String[] args = new String[1];
        args[0] = "1";

        Runner runner = new Runner(args);

        assertInstanceOf(StringReader.class, runner.getReader());
        assertInstanceOf(ConsolePrinter.class, runner.getPrinter());
    }

    @Test
    void oneInputFile() {
        String[] args = new String[1];
        args[0] = "input.txt";

        Runner runner = new Runner(args);

        assertInstanceOf(FileReader.class, runner.getReader());
        assertInstanceOf(ConsolePrinter.class, runner.getPrinter());
    }

    @Test
    void twoInputStringAndFile() {
        String[] args = new String[2];
        args[0] = "1";
        args[1] = "output.txt";

        Runner runner = new Runner(args);

        assertInstanceOf(StringReader.class, runner.getReader());
        assertInstanceOf(InFilePrinter.class, runner.getPrinter());
    }

    @Test
    void twoInputFileAndFile() {
        String[] args = new String[2];
        args[0] = "input.txt";
        args[1] = "output.txt";

        Runner runner = new Runner(args);

        assertInstanceOf(FileReader.class, runner.getReader());
        assertInstanceOf(InFilePrinter.class, runner.getPrinter());
    }
}