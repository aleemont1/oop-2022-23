package it.unibo.shapes.impl;

public class Square implements it.unibo.shapes.api.Polygon {
    private final double side;
    private final int edgeCount;

    public Square(final double side) {
        this.side = side;
        this.edgeCount = 4;
    }

    public double getSide() {
        return this.side;
    }

    public int getEdgeCount() {
        return this.edgeCount;
    }

    public double getArea() {
        return this.side * this.side;
    }

    public double getPerimeter() {
        return 4 * this.side;
    }
}