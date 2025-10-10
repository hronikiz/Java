package lab1;
class Point {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }
}

class Circle extends Point {
    protected double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public void print() {
        super.print();
        System.out.println("Circle with radius: " + radius);
    }
}

class Tank extends Circle {
    protected double height;

    public Tank(double x, double y, double radius, double height) {
        super(x, y, radius);
        this.height = height;
    }

    public double volume() {
        return Math.PI * radius * radius * height;
    }

    public void print() {
        super.print();
        System.out.println("Tank height: " + height);
        System.out.printf("Tank volume: %.2f%n", volume());
    }
}

public class Main {
    public static void main(String[] args) {
        Tank tank1 = new Tank(1, 3, 3, 10);  
        Tank tank2 = new Tank(0, 0, 2, 5);   

        tank1.print();
        System.out.println();
        tank2.print();
        System.out.println();

        int fullTanks = (int)(tank1.volume() / tank2.volume());
        System.out.println("Full smaller tanks in a large one: " + fullTanks);
    }
}
