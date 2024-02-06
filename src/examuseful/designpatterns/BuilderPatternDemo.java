package examuseful.designpatterns;

/*
The Builder pattern is a creational design pattern that provides a flexible solution to various object creation
problems. It is used to construct a complex object step by step and the final step will return the object. The process
of constructing an object should be generic so that it can be used to create different representations of the same object.

Here's a simple implementation example in Java that demonstrates the Builder pattern. We will create a Car class
and a corresponding CarBuilder class to construct a Car object piece by piece.
 */


/*
Step 1: Define the Product class

The Car class contains properties that we want to set through the builder.
 */
class Car {
    private String make;
    private String model;
    private int year;
    private String color;

    // Constructor is private to force use of the Builder
    private Car() {
    }

    // Getters for Car properties
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }

    // Static inner Builder class
    public static class Builder {
        private Car car;

        public Builder() {
            car = new Car();
        }

        public Builder make(String make) {
            car.make = make;
            return this;
        }

        public Builder model(String model) {
            car.model = model;
            return this;
        }

        public Builder year(int year) {
            car.year = year;
            return this;
        }

        public Builder color(String color) {
            car.color = color;
            return this;
        }

        public Car build() {
            return car;
        }
    }
}

/*
Step 2: Use the Builder

With the Car and its Builder defined, we can now construct Car objects with varying properties without
needing a constructor with many parameters.
 */

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .make("Honda")
                .model("Civic")
                .year(2020)
                .color("Red")
                .build();

        System.out.println("Car built: " + car.getMake() + " " + car.getModel() + " " + car.getYear() + " " + car.getColor());
    }
}
