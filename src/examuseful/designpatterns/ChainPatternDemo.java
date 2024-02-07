package examuseful.designpatterns;

/*
The Chain of Responsibility pattern is a behavioral design pattern that allows passing the request along a chain
of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next
handler in the chain.

Here's a simple implementation example in Java that demonstrates the Chain of Responsibility pattern. We will create
a chain of objects to process different types of log messages: debug, info, and error.
 */

/*
Step 1: Define the Handler interface

The Handler interface declares a method for setting the next handler in the chain and the method for processing a request.
 */
abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // The next element in the chain of responsibility
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

/*
Step 2: Create Concrete Handlers

These are specific classes that extend the Logger class and implement the write method to handle
the request they are responsible for.
 */
class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

class ErrorLogger extends Logger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

/*
Step 3: Build the Chain
 */
public class ChainPatternDemo {
    private static Logger getChainOfLoggers() {

        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an information.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");
        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
    }
}

/*
Explanation

In this example, Logger is the abstract handler, and ConsoleLogger, ErrorLogger, and FileLogger are the concrete
handlers. Each logger has a level, and they will only process messages that are of that level or higher.
Messages are passed along the chain until they are processed.

    ErrorLogger handles ERROR messages and passes other messages (INFO and DEBUG) along the chain.
    FileLogger handles DEBUG and ERROR messages and passes INFO messages along the chain.
    ConsoleLogger handles all messages.

The ChainPatternDemo class demonstrates setting up the chain and using it to process a set of messages.
Each message is processed by the first appropriate handler in the chain. This pattern decouples the sender of a
request from its receivers, allowing for dynamic handling of requests.
 */