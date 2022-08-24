package com.company.printer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.company.enums.Messages.RESULTS_TO_FILE;
import static com.company.enums.Messages.WRITING_ERROR_OR_DIRECTORY;

/**
 * Printer for creating file output.
 */
public class InFilePrinter implements Printer {
    private String filepath;
    private List<Integer> list;

    /**
     * @param filepath Class constructor with specified path for output file.
     */
    public InFilePrinter(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Sets input list of numbers which should be printed.
     * @param list List of integers.
     */
    public void setList(List<Integer> list) {
        this.list = list;
    }

    /**
     * Prints list into file specified by filepath.
     * Success printing is announced by message in console.
     * In case of error returns message to console.
     */
    public void printResult() {
        try {
            FileWriter writer = new FileWriter(filepath);
            for (Integer str : list) {
                writer.write(str + " ");
            }
            writer.close();
            System.out.println(RESULTS_TO_FILE.getMessage() + filepath);
        } catch (IOException e) {
            System.out.println(WRITING_ERROR_OR_DIRECTORY.getMessage());
        }
    }
}
