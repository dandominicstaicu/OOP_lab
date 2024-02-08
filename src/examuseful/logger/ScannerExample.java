package examuseful.logger;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerExample {
    private static final Logger LOGGER = Logger.getLogger(ScannerExample.class.getName());

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter your input: ");
            String input = scanner.nextLine(); // Reads a line of input
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An exception occurred while reading input", e);
        } finally {
            if (scanner != null) {
                scanner.close(); // It's a good practice to close the scanner
            }
        }
    }
}
