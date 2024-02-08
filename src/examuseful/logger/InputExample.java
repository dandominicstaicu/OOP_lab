package examuseful.logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputExample {
    private static final Logger LOGGER = Logger.getLogger(InputExample.class.getName());

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your input: ");
            String input = reader.readLine();
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An exception occurred while reading input", e);
        }
    }
}
