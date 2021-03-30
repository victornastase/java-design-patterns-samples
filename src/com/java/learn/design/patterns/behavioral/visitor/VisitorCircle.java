package com.java.learn.design.patterns.behavioral.visitor;

public class VisitorCircle extends VisitorDot {
    private int radius;

    public VisitorCircle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    public int getRadius() {
        return radius;
    }
}
