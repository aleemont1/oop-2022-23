package it.unibo.shapes.impl;

public class Square implements it.unibo.shapes.api.Polygon {
    private final double side;
    private final int edgeCount;

    public Square(final double side) {
        this.side = side;
        this.edgeCount = 4;
    }

    public double getSide() {
        return side;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}