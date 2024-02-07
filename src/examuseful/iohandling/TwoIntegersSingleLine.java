package examuseful.iohandling;

import java.util.Scanner;

/**
 * Example 2: Expecting Two Integers on the Same Line, But Only One is Given
 */

public class TwoIntegersSingleLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers on the same line:");

        try {
            int firstInt = scanner.nextInt();
            int secondInt = scanner.nextInt();
            System.out.println("You entered: " + firstInt + " and " + secondInt);
        } catch (Exception e) {
            System.out.println("Error: Insufficient integers provided.");
        } finally {
            scanner.close();
        }
    }
}
