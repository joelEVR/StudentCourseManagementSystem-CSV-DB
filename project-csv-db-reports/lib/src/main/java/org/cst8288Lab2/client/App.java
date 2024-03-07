package org.cst8288Lab2.client;

import java.io.IOException;
import java.util.List;

import org.cst8288Lab2.config.LoggerManager;
import org.cst8288Lab2.services.DataCSVProcessor;

/**
 * Author: Joel Esteban Velasquez Rodriguez, 041092394
 * Course: CST8288 – OOP with Design Patterns
 * Assignment: Lab 2
 * Date: 03 Mar 2024
 */

/**
 * The entry point for the application that processes student-course data.
 * This class is responsible for initiating the parsing of a CSV file named 'bulk-import.csv'.
 * It validates the data contained in each row of the file and performs updates to the database based on this data.
 * After processing, it outputs a report to the console, listing both successfully processed entries and any errors encountered.
 */
public class App {

    /**
     * The main method that drives the application.
     * It reads the 'bulk-import.csv' file, processes its content, and logs the outcome.
     * Valid entries are saved to the database, and any validation errors are reported.
     * 
     * @param args Command line arguments (not used).
     * @throws IOException If there is an error reading the 'bulk-import.csv' file.
     */
    public static void main(String[] args) throws IOException {
        // Assumption: the client provides the input file, and the program processes it,
        // generating a report while also saving correct data to the database.

    	DataCSVProcessor dataCSVProcessor = new DataCSVProcessor();
        List<String> lines = dataCSVProcessor.readLines("./data/bulk-import.csv");
        dataCSVProcessor.processData(lines);
        List<String> logInvalid = LoggerManager.Instance().getInvalid();
        List<String> logValid = LoggerManager.Instance().getValid();

        // Output the logs for valid and invalid processed data
        for (String log : logValid) {
            System.out.println(log);
        }
        
        for (String log : logInvalid) {
            System.out.println(log);
        }
    }
}
