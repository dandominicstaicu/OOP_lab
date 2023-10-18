package lab02.task03;

import java.util.*;

class Point {
    private float x;
    private float y;

    // TODO: Add constructor.
    public Point (float x, float y) {
        this.x = x;
        this.y = y;
    }

    // TODO: Add changeCoords.
    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // TODO: Add showPoint.
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void showPoint() {
        System.out.println(this);
    }
}

class Polygon {
    private Point[] points;

    // TODO: Add constructors.
    public Polygon(int cornerCount) {
        points = new Point[cornerCount];
    }

    public Polygon(float[] coords) {
        this(coords.length / 2);

        for (int i = 0; i < coords.length / 2; ++i) {
            points[i] = new Point(coords[2 * i], coords[2 * i + 1]);
        }
    }

    // TODO: Add showPolygon.
    public void showPolygon() {
        for (Point point : points) {
            System.out.println(point);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float x1 = scanner.nextFloat();
        float y1 = scanner.nextFloat();
        float x2 = scanner.nextFloat();
        float y2 = scanner.nextFloat();

        // TODO: Uncomment the code after implementing the task.
        Point point = new Point(x1, y1);
        point.showPoint();

        point.changeCoords(x2, y2);
        point.showPoint();

        int n = scanner.nextInt();
        float[] points = new float[n];

        for(int i = 0; i < n; i++) {
            points[i] = i;
        }

        Polygon polygon = new Polygon(points);
        System.out.println("Poligonul are urmatoarele coordonate:");
        polygon.showPolygon();

    }
}