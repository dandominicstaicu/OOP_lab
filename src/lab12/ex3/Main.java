package lab12.ex3;

import java.util.EnumSet;

// a) Enumerația LogLevel
enum LogLevel {
    Info, Debug, Warning, Error, FunctionalMessage, FunctionalError;

    public static EnumSet<LogLevel> all() {
        return EnumSet.allOf(LogLevel.class);
    }
}

// b) Clasa abstractă LoggerBase
abstract class LoggerBase {
    protected EnumSet<LogLevel> levels;
    private LoggerBase next;

    public LoggerBase(EnumSet<LogLevel> levels) {
        this.levels = levels;
    }

    public void setNext(LoggerBase nextLogger) {
        this.next = nextLogger;
    }

    protected abstract void writeMessage(String msg);

    public void message(String msg, LogLevel severity) {
        if (levels.contains(severity)) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, severity);
        }
    }
}

// c) Clasele care extind LoggerBase
class ConsoleLogger extends LoggerBase {
    public ConsoleLogger() {
        super(LogLevel.all());
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[Console] " + msg);
    }
}

class EmailLogger extends LoggerBase {
    public EmailLogger() {
        super(EnumSet.of(LogLevel.FunctionalMessage, LogLevel.FunctionalError));
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[Email] " + msg);
    }
}

class FileLogger extends LoggerBase {
    public FileLogger() {
        super(EnumSet.of(LogLevel.Warning, LogLevel.Error));
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[File] " + msg);
    }
}

// d) Completați în metoda main
public class Main {
    public static void main(final String[] args) {
        LoggerBase logger1 = new ConsoleLogger();
        LoggerBase logger2 = new EmailLogger();
        LoggerBase logger3 = new FileLogger();

        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.message("Se execută metoda ProcessOrder()", LogLevel.Debug);
        logger1.message("Comanda a fost procesată cu succes", LogLevel.Info);
        logger1.message("Datele despre adresa clientului lipsesc din baza de date a filialei", LogLevel.Warning);
        logger1.message("Detele despre adresa clientului lipsesc din baza de date a organizației", LogLevel.Error);
        logger1.message("Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1",
                LogLevel.FunctionalError);
        logger1.message("Comandă procesată", LogLevel.FunctionalMessage);
    }
}
