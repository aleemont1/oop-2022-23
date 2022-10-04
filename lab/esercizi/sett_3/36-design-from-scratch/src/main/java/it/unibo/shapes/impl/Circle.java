package it.unibo.shapes.impl;

public class Circle implements it.unibo.shapes.api.Shape {
    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

}