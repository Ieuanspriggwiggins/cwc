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


}
