package examuseful.designpatterns;

import java.util.ArrayList;
import java.util.List;

/*

The Observer pattern is a software design pattern that defines a one-to-many dependency between objects so
that when one object changes state, all its dependents are notified and updated automatically. It's commonly
used for implementing distributed event handling systems, in model-view-controller (MVC) architectures, etc.

Here's a simple implementation example in Java that demonstrates the Observer pattern. We'll create a simple
subject (also known as an observable) that notifies observers about changes. For simplicity, we'll have a Subject
that holds an integer state and a list of observers. When the state changes, the Subject notifies all registered
observers.

 */

/*
Step 1: Define the Observer interface

The Observer interface declares the notification interface (update) that the subjects use to notify their observers.
 */

interface Observer {
    void update(int state);
}

/*
Step 2: Define the Subject class

The Subject class maintains a list of its observers and notifies them of state changes.
 */

class Subject {

    /* The Subject class maintains a list of its observers and notifies them of state changes. */
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

/*
Step 3: Create Concrete Observers

These are specific implementations of the Observer interface that perform some action in response to being notified
of state changes.
 */

class ConcreteObserverA implements Observer {
    @Override
    public void update(int state) {
        System.out.println("ConcreteObserverA: observed state change to " + state);
    }
}

class ConcreteObserverB implements Observer {
    @Override
    public void update(int state) {
        System.out.println("ConcreteObserverB: observed state change to " + state);
    }
}

/*
Step 4: Demonstrate the Observer pattern
 */

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        ConcreteObserverA observerA = new ConcreteObserverA();
        ConcreteObserverB observerB = new ConcreteObserverB();

        subject.attach(observerA);
        subject.attach(observerB);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
