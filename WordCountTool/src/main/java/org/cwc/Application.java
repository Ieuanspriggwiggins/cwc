/**
 * Main application file
 *
 * @author ieuan sprigg-wiggins
 * @version 1.0
 */

package org.cwc;

public class Application{

    public static void main(String[] args) {
        //If no arguments provided, provide error
        if(args.length == 0){
            System.err.println("Usage: cwc [-c, -w] [filename] - If no flag provided, default used is -c");
            return;
        }

        String filename = args[args.length - 1];
    }
}