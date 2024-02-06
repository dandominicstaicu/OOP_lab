package examuseful.designpatterns;

/*
The Command pattern is a behavioral design pattern that turns a request into a stand-alone object that
contains all information about the request. This transformation allows you to parameterize methods with
different requests, delay or queue a request's execution, and support undoable operations.

Here's a simple implementation example in Java that demonstrates the Command pattern. We will create a command
interface, several concrete command classes, a class that acts as an invoker, and a receiver class that performs
the actual actions.
 */

/*
Step 1: Define the Command interface

The Command interface declares a method for executing a command.
 */

interface Command {
    void execute();
}

/*
Step 2: Create the Receiver class

The Receiver class has the actual logic to perform the specific actions.

*/

class Light {
    public void turnOn() {
        System.out.println("Light is On");
    }

    public void turnOff() {
        System.out.println("Light is Off");
    }
}

/*
Step 3: Create Concrete Command classes

These classes implement the Command interface, defining a binding between a Receiver object and an action.
 */
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

/*
Step 4: Define the Invoker class

The Invoker class asks the command to carry out the request.
 */
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

/*
Step 5: Demonstrate the Command pattern
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton(); // Output: Light is On

        remote.setCommand(turnOff);
        remote.pressButton(); // Output: Light is Off
    }
}
