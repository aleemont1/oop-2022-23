package it.unibo.shapes.impl;

public class Triangle implements it.unibo.shapes.api.Polygon {
    private final double base;
    private final double height;
    private final int edgeCount;

    public Triangle(final double base, final double height) {
        this.base = base;
        this.height = height;
        this.edgeCount = 3;
    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    public int getEdgeCount() {
        return this.edgeCount;
    }

    public double getArea() {
        return this.base * this.height / 2;
    }

    public double getPerimeter() {
        return this.base + 2 * Math.sqrt(this.base * this.base / 4 + this.height * this.height);
    }
}