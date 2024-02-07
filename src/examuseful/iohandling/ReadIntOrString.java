package examuseful.iohandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Example 1: Reading an Integer or a String
 *
 * Handling a scenario where the user might enter a string instead of an integer.
 */

public class ReadIntOrString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer or a string:");

        try {
            int number = scanner.nextInt();
            System.out.println("You entered the integer: " + number);
        } catch (InputMismatchException e) {
            String input = scanner.next(); // Read the non-integer input
            System.out.println("You entered a string: " + input);
        } finally {
            scanner.close();
        }
    }
}
