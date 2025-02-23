/**
 * Main program file
 *
 * @author ieuan sprigg-wiggins
 * @version 1.0
 */

package org.cwc;

public class Program {

    //Entry point for the program
    public static void main(String[] args) {
        if(args.length == 0){
            System.err.println("Usage: cwc [args] [filename]");
            return;
        }

        Application app = new Application(args);
        app.appStart();
    }
}