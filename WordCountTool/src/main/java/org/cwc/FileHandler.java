/**
 * Class responsible for handling interactions between application and files. Specifically made this way for
 * extensibility for future additions or features.
 */

package org.cwc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {

    private final File file;

    /**
     * Constructor for the file handler class.
     * @param filename - The name of the file being opened
     */
    public FileHandler(String filename) {
        this.file = new File(filename);
    }

    /**
     * Returns the amount of lines present in a given file. Will return 0 by default.
     * @return - amount of lines present in file
     * @throws FileNotFoundException - if the file is not found.
     */
    public int getFileLineCount() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);

        int count = 0;
        while(scanner.hasNextLine()){
            count++;
        }

        return count;
    }

    /**
     * Returns the amount of bytes present in a file.
     * @return - the number of bytes as an integer.
     * @throws FileNotFoundException - If the file does not exist.
     */
    public int getFileByteCount() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);

        int count = 0;
        while(scanner.hasNextByte()){
            count++;
        }
        return count;
    }

    public int getFileWordCount() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);

        int count = 1;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(char c : line.toCharArray()){
                if(c == ' ' || c == '\n' || c == '\r'){
                    count++;
                }
            }
        }

        return count;
    }
}
