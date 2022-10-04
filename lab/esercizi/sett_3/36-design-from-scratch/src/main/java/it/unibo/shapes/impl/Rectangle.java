package it.unibo.shapes.impl;

public class Rectangle implements it.unibo.shapes.api.Polygon {
    private final double width;
    private final double height;
    private final int edgeCount;

    public Rectangle(final double width, final double height){
        this.width = width;
        this.height = height;
        this.edgeCount = 4;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public int getEdgeCount(){
        return edgeCount;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2 * (width + height);
    }
}