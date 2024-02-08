//package examuseful.logger;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class InputExampleLog4j {
//    private static final Logger LOGGER = LogManager.getLogger(InputExampleLog4j.class);
//
//    public static void main(String[] args) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter your input: ");
//            String input = reader.readLine();
//            System.out.println("You entered: " + input);
//        } catch (Exception e) {
//            LOGGER.error("An exception occurred while reading input", e);
//        }
//    }
//}
