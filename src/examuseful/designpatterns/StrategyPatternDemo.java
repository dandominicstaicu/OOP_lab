package examuseful.designpatterns;

/*
The Strategy pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime.
Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of
algorithms to use. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy
lets the algorithm vary independently from clients that use it.

Here's a simple implementation example in Java that demonstrates the Strategy pattern. We will create a context class
that can use different strategies, and several concrete strategy classes that implement a common strategy interface.
 */

/*
Step 1: Define the Strategy interface

The Strategy interface declares the operation(s) that all concrete strategies must implement.
 */

interface Strategy {
    void execute(int num1, int num2);
}


/*
Step 2: Create Concrete Strategies

These are specific implementations of the Strategy interface, representing different algorithms
that can be dynamically chosen at runtime.
 */

class AddStrategy implements Strategy {
    @Override
    public void execute(int num1, int num2) {
        System.out.println("Adding: " + (num1 + num2));
    }
}

class SubtractStrategy implements Strategy {
    @Override
    public void execute(int num1, int num2) {
        System.out.println("Subtracting: " + (num1 - num2));
    }
}

class MultiplyStrategy implements Strategy {
    @Override
    public void execute(int num1, int num2) {
        System.out.println("Multiplying: " + (num1 * num2));
    }
}


/*
Step 3: Define the Context class

The Context class maintains a reference to one of the concrete strategies and communicates with
this strategy only via the strategy interface.
 */

class Context {
    private Strategy strategy;

    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int num1, int num2) {
        strategy.execute(num1, num2);
    }
}

/* Step 4: Demonstrate the Strategy pattern */

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        context.executeStrategy(3, 4); // Output: Adding: 7

        context.setStrategy(new SubtractStrategy());
        context.executeStrategy(5, 3); // Output: Subtracting: 2

        context.setStrategy(new MultiplyStrategy());
        context.executeStrategy(6, 7); // Output: Multiplying: 42
    }
}
