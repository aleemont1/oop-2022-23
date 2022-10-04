package it.unibo.shapes.impl;

public class Triangle implements it.unibo.shapes.api.Polygon {
    private final double base;
    private final double height;
    private final int edgeCount;

    public Triangle(final double base, final double height){
        this.base = base;
        this.height = height;
        this.edgeCount = 3;
    }

    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }

    public int getEdgeCount(){
        return edgeCount;
    }

    public double getArea(){
        return base * height / 2;
    }

    public double getPerimeter(){
        return base + 2 * Math.sqrt(base * base / 4 + height * height);
    }
}