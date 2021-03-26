package com.java.learn.design.patterns.structural.bridge;

public class Circle extends AbstractShape {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius, Draw draw) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        draw.drawCircle(radius, x, y);
    }
}
