/*
 * Name:        CoordDistance
 * Author:      Dylan & Yifan
 * Date:        Feb 3, 2017
 * Purpose:     Calculates the distance between two coordinates
 *              using the distance formula.
 */
package com.EverythingTech;
import java.util.Scanner;

public class CoordDistance {

    // the x and y values for the two coordinates
    private static double x1 = 0.0;
    private static double y1 = 0.0;
    private static double x2 = 0.0;
    private static double y2 = 0.0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1; // input for the first coordinate, stored in a string with format (x,y)
        String input2; // input for the second coordinate, stored in a string with format (x,y)
        double d;

        boolean inputErr = true;

        // Gather information from user
        do{

            System.out.println("Enter the first coordinate (x,y): ");
            input1 = scan.nextLine();
            System.out.println("Enter the second coordinate (x,y): ");
            input2 = scan.nextLine();
            if(record(input1, true) && record(input2, false))
                inputErr = false;

        }while(inputErr); // Repeats if  exception thrown when parsing double

        scan.close(); // Input complete. Move on to calculation.

        // Calculate using distance formula
        d = Math.sqrt(Math.pow((x1 - x2), 2.0) + Math.pow((y1 - y2), 2.0));

        // Output result
        System.out.println("Distance d = " + d); // Outputs the result

    } // main

    /*
    Precondition:
        Given the input string and the coordinate
        1 for first coordinate
        0 for second coordinate
    Postcondition:
        Returns true if no exception is thrown; false otherwise.
        Stores the given coordinate into the coresponding variables.
     */
    public static boolean record (String str, boolean coord){
        // 1 for first coordinate
        // 0 for second coordinate
        try {

            str.replaceAll("\\s+",""); // removes all whitespaces and non-visible characters (e.g., tab, \n)

            if (coord) {
                x1 = Double.parseDouble(str.replaceAll(",.*", ""));
                y1 = Double.parseDouble(str.replaceAll(".*,", ""));
            } else {
                x2 = Double.parseDouble(str.replaceAll(",.*", ""));
                y2 = Double.parseDouble(str.replaceAll(".*,", ""));
            } // if else
        } catch (Exception e){
            System.out.println("Wrong input type");
            return false;
        } // try catch

        return true;
    } // record
} // CoordDistance
