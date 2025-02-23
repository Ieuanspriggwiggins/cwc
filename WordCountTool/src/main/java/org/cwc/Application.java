/**
 * Main logic for the application
 * @author ieuan sprigg-wiggins
 * @version 1.0
 */

package org.cwc;

import java.io.FileNotFoundException;

public class Application {

    private final String filename;

    //Arguments passed into the application
    private final String[] args;
    FileHandler fileHandler;

    /**
     * Constructor for the Application class
     * @param args - The args passed into the main method
     */
    public Application(String[] args) {
        this.args = args;
        this.filename = args[args.length - 1];
    }

    /**
     * The starting point for the application logic.
     */
    public void appStart() {
        //The application should not go any further if the arguments are empty or missing
        fileHandler = new FileHandler(filename);

        StringBuilder outputString = new StringBuilder();

        try {
            switch (args[0]) {
                case "-l":
                    outputString.append(fileOperation("-l"));
                    break;
                case "-w":
                    outputString.append(fileOperation("-w"));
                    break;
                case "-c":
                    outputString.append(fileOperation("-c"));
                default:
                    outputString.append(fileOperation("all"));
            }
        }catch(Exception e){
            System.err.println("File not found, please try again with a different filename\n");
        }

        outputString.append(" ");
        outputString.append(args[args.length-1]);

        System.out.println(outputString);
    }

    /**
     * Runs one of the file operations depending on the given mode determined by user arguments.
     * @param mode - the type of operation being performed.
     * @return A formatted string with the information
     * @throws FileNotFoundException - if the file is not found
     */
    public String fileOperation(String mode) throws FileNotFoundException {
        try {
            return switch (mode) {
                case "-c" -> "  " + fileHandler.getFileByteCount() + "  ";
                case "-l" -> "  " + fileHandler.getFileLineCount() + "   ";
                case "-w" -> "  " + fileHandler.getFileWordCount() + "   ";
                default -> "    " +
                        fileHandler.getFileByteCount() + "  " +
                        fileHandler.getFileLineCount() + "  " +
                        fileHandler.getFileWordCount() + "  ";
            };
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new FileNotFoundException();
        }
    }
}
