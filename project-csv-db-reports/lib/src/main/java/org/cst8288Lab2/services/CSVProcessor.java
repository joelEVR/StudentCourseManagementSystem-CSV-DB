package org.cst8288Lab2.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a template for processing CSV files. This abstract class defines
 * methods for reading lines from a file and writing data to a file, as well as
 * an abstract method for processing data.
 */
public abstract class CSVProcessor implements FileProcessor {
    
    /**
     * Reads all lines from a specified CSV file and returns them as a List of Strings.
     *
     * @param filename The path of the file to be read.
     * @return A List containing all lines read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Override
    public List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (InputStream in = new FileInputStream(filename); BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * Writes a string of data to a specified file. If the file already exists, it will be overwritten.
     *
     * @param data The string of data to write to the file.
     * @param filename The path of the file where the data will be written.
     */
    @Override
    public void writeFile(String data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
            System.out.println("Report generated successfully at: " + filename);
            
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
        System.out.println(); // Agrega un salto de línea después de la ejecución de try-catch

    }

    /**
     * Abstract method for processing a list of strings, typically representing lines of a CSV file.
     * Implementing classes must define the specifics of the processing.
     *
     * @param lines A List of strings representing the lines of the file to be processed.
     * @throws IOException If an I/O error occurs during processing.
     */
    public abstract void processData(List<String> lines) throws IOException;

}
