package examrecap.exception;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        try {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int result = x / y;

            System.out.println(result);

        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}