package lab03;

import java.net.SecureCacheResponse;
import java.util.Objects;
import java.util.Scanner;

class Form {

    // TODO[0]: Add fields
    private String color;

    public String getColor() {
        return color;
    }

    // TODO[1]: Add constructors
    public Form() {
        this.color = "white";
    }

    public Form(String color) {
        this.color = color;
    }

    // TODO[2]: Add the function getArea
    public float getArea() {
        return 0;
    }

    // TODO[3]: Override toString

    @Override
    public String toString() {
        return "This form has the color " + this.color;
    }

    public void printDimensions() {

    }
}

class Triangle extends Form {
    // TODO[0]: Add fields
    private float height;
    private float base;

    // TODO[1]: Add constructors
    public Triangle() {
        this.base = 0;
        this.height = 0;
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.base = base;
        this.height = height;
    }

    // TODO[2]: Override toString
    @Override
    public String toString() {
        return "Triangle: " + super.toString();
    }

    // TODO[3]: Override getArea
    @Override
    public float getArea() {
        return this.base * this.height / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(base, triangle.base) == 0 &&
                Float.compare(height, triangle.height) == 0 &&
                this.getColor().equals(triangle.getColor());
    }

    public void printTriangleDimensions() {
        System.out.println("Height: " + this.height + " Base: " + this.base);
    }

    @Override
    public void printDimensions() {
        System.out.println("Height: " + this.height + " Base: " + this.base);
    }
}

class Square extends Form {

    // TODO[0]: Add fields
    private float side;

    // TODO[1]: Add constructors
    public Square() {
        this.side = 0;
    }

    public Square(String color, float side) {
        super(color);
        this.side = side;
    }

    // TODO[2]: Override toString
    @Override
    public String toString() {
        return "Square: " + super.toString();
    }

    // TODO[3]: Override getArea
    @Override
    public float getArea() {
        return this.side * this.side;
    }

    public void printSquareDimensions() {
        System.out.println("Side: " + this.side);
    }

    @Override
    public void printDimensions() {
        System.out.println("Side: " + this.side);
    }
}

class Circle extends Form {
    // TODO[0]: Add fields
    private float radius;

    // TODO[1]: Add constructors
    public Circle() {
        this.radius = 0;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    // TODO[2]: Override toString
    @Override
    public String toString() {
        return "Circle: " + super.toString();
    }

    // TODO[3]: Override getArea
    @Override
    public float getArea() {
        return (float) (Math.PI * this.radius * this.radius);
    }

    public void printCircleDimensions() {
        System.out.println("Radius: " + this.radius);
    }

    @Override
    public void printDimensions() {
        System.out.println("Radius: " + this.radius);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();
        // TODO: Uncomment the code after implementing the task.
        // Task 1:

        Form form1 = new Form();
        Form form2 = new Form("blue");

        // Task 2:
        Triangle triangle1 = new Triangle("red", 4, 3);
        Triangle triangle2 = new Triangle();
        Square square1 = new Square("yellow", 4);
        Square square2 = new Square();
        Circle circle1 = new Circle("green",10);
        Circle circle2 = new Circle();

//        Task 4: add in this order the elements in the shape vector: triangle1, triangle2,
//                  square1, square2, circle1, circle2

        Form [] forms = new Form[6];
        forms[0] = triangle1;
        forms[1] = triangle2;
        forms[2] = square1;
        forms[3] = square2;
        forms[4] = circle1;
        forms[5] = circle2;

        switch(task) {
            case 1:
//                Task 1:
                System.out.println(form1);
                System.out.println(form2);
                break;
            case 2:
//                Task 2:
                System.out.println(triangle1);
                System.out.println("The Area is: " + triangle1.getArea());
                System.out.println(triangle2);
                System.out.println("The Area is: " + triangle2.getArea());
                System.out.println(square1);
                System.out.println("The Area is: " + square1.getArea());
                System.out.println(square2);
                System.out.println("The Area is: " + square2.getArea());
                System.out.println(circle1);
                System.out.println("The Area is: " + circle1.getArea());
                System.out.println(circle2);
                System.out.println("The Area is: " + circle2.getArea());
                break;
            case 3:
//                Task 3:
                Triangle triangle3 = new Triangle("yellow", 4, 3);
                Triangle triangle4 = new Triangle("red", 4, 3);
                System.out.println(triangle1.equals(triangle3));
                System.out.println(triangle1.equals(triangle4));
                System.out.println(triangle1.equals(square1));
                break;
            case 4:
                // Task 4: for each element of the vector call the toString function
                for (Form form : forms) {
                    System.out.println(form);
                }
                break;

            case 5:
                // Task 5: Loop through the vector from the previous exercise and, using downcasting to the appropriate class, call
                // methods specific to each class (printTriangleDimensions for Triangle, printCircleDimensions for Circle
                // printSquareDimensions for Square)
                for (Form form : forms) {
                    if (form instanceof Triangle) {
                        ((Triangle) form).printTriangleDimensions();
                    } else if (form instanceof Circle) {
                        ((Circle) form).printCircleDimensions();
                    } else if (form instanceof Square) {
                        ((Square) form).printSquareDimensions();
                    }
                }
                break;
            case 6:
                //Task 6: Show shape sizes without using instanceof
                for (Form form : forms) {
                    form.printDimensions();
                }
                break;
        }
    }
}
