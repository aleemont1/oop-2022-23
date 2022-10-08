package it.unibo.shapes.impl;

public class Square implements it.unibo.shapes.api.Polygon {
    private final double side;
    private static final int EDGES = 4;

    public Square(final double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public int getEdgeCount() {
        return this.EDGES;
    }

    public double getArea() {
        return this.side * this.side;
    }

    public double getPerimeter() {
        return 4 * this.side;
    }
}
