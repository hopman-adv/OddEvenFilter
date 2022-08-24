package com.company.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.enums.Messages.FILE_NOT_FOUND;
import static com.company.enums.Messages.SKIPPING_INCORRECT_CHAR;

/**
 * Reader for file input.
 */
public class FileReader implements Reader {
    private String filepath;

    /**
     * Class constructor.
     */
    public FileReader() {
    }

    /**
     * Class constructor with specific filepath.
     * @param filepath path for input file which will be read.
     */
    public FileReader(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Sets path for input file.
     * @param filepath Input file filepath as a String.
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Gets all positive/zero Integer values from provided file.
     * Skips all incorrect characters (letters, negative values, non-integers).
     * Writes message to console for incorrect characters and missing input file.
     * @return List of non-negative Integers.
     */
    @Override
    public List<Integer> getInput() {
        List<Integer> data = new ArrayList<Integer>();
        try {
            File file = new File(filepath);
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                if(reader.hasNextInt()) {
                    int val = reader.nextInt();
                    if(isPositive(val)) {
                        data.add(val);
                    }
                } else {
                    System.out.println(SKIPPING_INCORRECT_CHAR.getMessage()+reader.next());
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND.getMessage() + filepath);
        }
        return data;
    }
}
