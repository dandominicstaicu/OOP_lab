package examuseful.iohandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * General Example: Reading from stdin and Writing to stdout with Exception Handling
 */

public class StdinStdoutExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter an integer:");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Error: Not an integer.");
        } finally {
            scanner.close();
        }
    }
}
