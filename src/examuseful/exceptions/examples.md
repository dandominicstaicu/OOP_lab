Java provides a robust framework for handling runtime errors or "exceptions" to maintain normal application flow. An exception is an event that disrupts the normal flow of the program's instructions. Here's an overview of how to use and handle exceptions in Java, including the aspects you asked about:

### Throwing Exceptions

In Java, an exception can be thrown either by the Java runtime system or by the application code. To throw an exception, use the `throw` keyword followed by an instance of `Throwable` (or any of its subclasses). For example:

```java
throw new Exception("An error occurred");
```

### Catching Exceptions

To catch exceptions, use a `try-catch` block. The `try` block contains the code that might throw an exception, and the `catch` block contains the code to handle the exception. Multiple catch blocks can be used to handle different types of exceptions separately.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType1 e) {
    // Handle ExceptionType1
} catch (ExceptionType2 e) {
    // Handle ExceptionType2
}
```

### Nested Try-Catch Blocks

Java allows using `try-catch` blocks inside another `try` or `catch` block, known as nested try-catch blocks. This is useful when different parts of a block may throw different exceptions that need distinct handling.

```java
try {
    // Outer try block
    try {
        // Inner try block that may throw an exception
    } catch (InnerException e) {
        // Handle exception thrown from the inner try block
    }
} catch (OuterException e) {
    // Handle exception thrown from the outer try block
}
```

### Finally Block

A `finally` block contains code that must be executed after the try block ends, regardless of whether an exception was thrown or caught. It's typically used for cleanup activities like closing file streams or releasing resources.

```java
try {
    // Code that may throw an exception
} catch (Exception e) {
    // Handle exception
} finally {
    // Code that will always run after the try or catch block
}
```

### Defining New Exceptions

You can define your own exception classes by extending the `Exception` class (for checked exceptions) or the `RuntimeException` class (for unchecked exceptions).

```java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

### Exceptions in Inheritance Context

When overriding methods in subclasses, Java's exception handling rules apply:

- If the superclass method does not throw an exception, the subclass overridden method cannot throw checked exceptions but can throw unchecked exceptions.
- If the superclass method throws an exception, the subclass overridden method can throw the same, subclass(es) of the exception, or no exception at all. It cannot throw broader checked exceptions.

```java
class Superclass {
    void method() throws IOException {
        // Superclass method
    }
}

class Subclass extends Superclass {
    @Override
    void method() throws FileNotFoundException {
        // Subclass method can throw FileNotFoundException,
        // which is a subclass of IOException
    }
}
```

These features form the core of Java's exception handling mechanism, enabling developers to write more reliable and error-resistant code by separating the error-handing code from the regular code flow.