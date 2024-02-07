package examrecap.iohandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOExample {
    public static void main(String[] args) {
        // Specify the file paths
        String inputFilePath = "input.txt"; // Input file path
        String outputFilePath = "output.txt"; // Output file path

        // Create File objects for both files
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        try {
            // Create Scanner object for reading the input file
            Scanner scanner = new Scanner(inputFile);

            // Create PrintWriter object for writing to the output file
            PrintWriter writer = new PrintWriter(outputFile);

            // Read from input file and write to output file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read a line
                writer.println(line); // Write the line to the output file
            }

            // Close both the scanner and writer to free resources
            scanner.close();
            writer.close();

            System.out.println("File has been copied.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
