package examuseful.designpatterns;

/*
The Visitor pattern is a behavioral design pattern that allows you to separate algorithms from the objects on
which they operate, making it easier to add new operations to existing object structures without changing those
structures. It involves a visitor class that changes the executing algorithm of an element class. By this way,
execution algorithm of element can vary as and when visitor varies.

Here's a basic implementation example in Java that demonstrates the Visitor pattern. We will create an object
structure (a set of elements) and a visitor that can perform operations on elements of the structure without changing
the classes of the elements.
 */

/*
Step 1: Define the Visitor interface

The Visitor interface declares a visit operation for each type of concrete element in the object structure.
 */

interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

/*
Step 2: Define the Element interface

The Element interface declares an accept method that takes a visitor object as an argument.
 */
interface Element {
    void accept(Visitor visitor);
}

/*
Step 3: Create Concrete Elements

These are classes implementing the Element interface, each with their own accept method that directs the
visitor to the appropriate visit method.
 */
class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String exclusiveMethodOfConcreteElementA() {
        return "A";
    }
}

class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String exclusiveMethodOfConcreteElementB() {
        return "B";
    }
}

/*
Step 4: Create Concrete Visitor classes

Concrete visitors implement the Visitor interface and define the operations to be performed on elements
of the object structure.
 */
class ConcreteVisitor1 implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitor1: " + element.exclusiveMethodOfConcreteElementA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitor1: " + element.exclusiveMethodOfConcreteElementB());
    }
}

class ConcreteVisitor2 implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitor2: " + element.exclusiveMethodOfConcreteElementA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitor2: " + element.exclusiveMethodOfConcreteElementB());
    }
}

/*
Step 5: Demonstrate the Visitor pattern

Finally, let's create a demo class to show how the Visitor pattern works in practice.
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Element[] elements = new Element[]{new ConcreteElementA(), new ConcreteElementB()};

        Visitor visitor1 = new ConcreteVisitor1();
        Visitor visitor2 = new ConcreteVisitor2();

        for(Element element : elements) {
            element.accept(visitor1);
        }

        for(Element element : elements) {
            element.accept(visitor2);
        }
    }
}
