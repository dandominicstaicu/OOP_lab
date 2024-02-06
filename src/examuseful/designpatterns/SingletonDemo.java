package examuseful.designpatterns;

/*
he Singleton pattern is a design pattern that ensures a class has only one instance,
and provides a global point of access to it. This pattern is particularly useful when exactly one
object is needed to coordinate actions across the system.

Here's a simple implementation example of the Singleton pattern in Java:
 */

/*
Step 1: Define the Singleton Class

The key parts of a singleton class are:

    A private static variable to hold the single instance of the class (instance)
    A private constructor to restrict instantiation of the class from outside
    A public static method that returns the single instance of the class
 */

class SingletonClass {
    // The private static variable that holds the single instance
    private static SingletonClass instance;

    // Private constructor so no instances can be created outside of this class
    private SingletonClass() {
    }

    // Public static method that returns the instance of the class
    public static SingletonClass getInstance() {
        if (instance == null) {
            // If the instance hasn't been created yet, create it here
            instance = new SingletonClass();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton class!");
    }
}


/*
Step 2: Demonstrate the Singleton Usage

To demonstrate the Singleton pattern, you can create a demo class where you attempt to get the instance of the Singleton class multiple times and call a method on it.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        // Illegal construct - compilation error because the constructor is private
        // Singleton object = new Singleton();

        // Get the only object available
        SingletonClass object = SingletonClass.getInstance();

        // Show the message
        object.showMessage();
    }
}
