package examuseful.designpatterns;

/*
The Factory Pattern is a creational design pattern that provides an interface for creating objects in a
superclass but allows subclasses to alter the type of objects that will be created. This pattern is particularly
useful when a system should be independent of how its products are created, composed, and represented.

Here's a simple implementation example in Java that demonstrates the Factory pattern. We will create a
factory method for generating different types of Product objects without specifying the exact class of the object
that will be created.
*/

/*
Step 1: Define the Product interface

The Product interface declares the operations that all concrete products must implement.
 */
interface Product {
    void use();
}

/*
Step 2: Create Concrete Products

These are implementations of the Product interface, representing different products that can be created by the factory.
 */
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductB");
    }
}

/*
Step 3: Define the Factory class

The Factory class declares the factory method that returns new product instances.
The factory method can be made abstract if you're defining it in a base class, or it can return a default product type.
 */

class Factory {
    public Product createProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ConcreteProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ConcreteProductB();
        }
        return null; // or throw an IllegalArgumentException
    }
}

/*
Step 4: Demonstrate the Factory pattern
 */

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Product productA = factory.createProduct("A");
        productA.use();

        Product productB = factory.createProduct("B");
        productB.use();
    }
}
