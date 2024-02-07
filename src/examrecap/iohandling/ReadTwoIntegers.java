package examrecap.iohandling;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Example 2: Expecting Two Integers on the Same Line, But Only One is Given
 *
 * This example demonstrates how to handle input when two integers are expected on the same line, but perhaps only
 * one is provided.
 */

public class ReadTwoIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers (on the same line):");

        try {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            System.out.println("You entered the integers: " + firstNumber + " and " + secondNumber);
        } catch (InputMismatchException e) {
            System.out.println("Error: You did not enter an integer.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: You did not enter enough integers.");
        } finally {
            scanner.close();
        }
    }
}
