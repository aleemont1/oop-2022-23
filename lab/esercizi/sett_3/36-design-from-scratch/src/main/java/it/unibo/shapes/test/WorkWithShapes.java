package it.unibo.shapes.test;
import it.unibo.shapes.api.*;
import it.unibo.shapes.impl.*;
class WorkWithShapes {
    public static void main(String[] args) {
        Polygon s = new Square(10);
        Polygon r = new Rectangle(10, 20);
        Polygon t = new Triangle(5, 10);
        Shape c = new Circle(10);
        
        System.out.println("Square area: " + s.getArea());
        System.out.println("Square perimeter: " + s.getPerimeter());
        System.out.println("Rectangle area: " + r.getArea());
        System.out.println("Rectangle perimeter: " + r.getPerimeter());
        System.out.println("Triangle area: " + t.getArea());
        System.out.println("Triangle perimeter: " + t.getPerimeter());
        System.out.println("Circle area: " + c.getArea());
        System.out.println("Circle perimeter: " + c.getPerimeter());
        
    }
}