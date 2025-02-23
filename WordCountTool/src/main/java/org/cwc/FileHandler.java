/**
 * Class responsible for handling interactions between application and files. Specifically made this way for
 * extensibility for future additions or features.
 */

package org.cwc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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
     * Gets the amount of bytes in a file
     * @return the number of bytes as an integer
     * @throws IOException If the file does not exist.
     */
    public int getFileByteCount() throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return fileContent.length;
    }

    /**
     * Gets the number of lines in a file as an integer.
     * @return The number of lines as integer
     * @throws FileNotFoundException If the file is not found
     */
    public int getFileLineCount() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int count = 0;
        while(scanner.hasNextLine()){
            count++;
            scanner.nextLine();
        }

        return count;
    }

    /**
     * Counts the number of words in a file.
     * @return the number of words in a file as a string
     * @throws FileNotFoundException - if the file is not found
     */
    public int getFileWordCount() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int count = 0;

        while(scanner.hasNext()){
            count++;
            scanner.next();
        }

        return count;
    }
}
