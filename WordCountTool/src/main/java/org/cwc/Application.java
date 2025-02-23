/**
 * Main logic for the application
 * @author ieuan sprigg-wiggins
 * @version 1.0
 */

package org.cwc;

public class Application {

    private String filename;

    //Arguments passed into the application
    private String[] args;
    FileHandler fileHandler;

    /**
     * Constructor for the Application class
     * @param args - The args passed into the main method
     */
    public Application(String[] args) {
        this.args = args;
    }

    /**
     * The starting point for the application logic.
     */
    public void appStart() {
        //The application should not go any further if the arguments are empty or missing.
        if(args.length == 0){
            System.err.println("Usage: cwc [args (-c, -w)] [filename]");
            return;
        }

        //Get the filename from arguements and pass it over to the file handler.
        this.filename = args[args.length - 1];

        this.fileHandler = new FileHandler(this.filename);

    }
}
