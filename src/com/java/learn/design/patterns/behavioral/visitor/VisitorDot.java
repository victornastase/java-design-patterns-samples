package com.java.learn.design.patterns.behavioral.visitor;

public class VisitorDot implements VisitorShape {
    private int id;
    private int x;
    private int y;

    public VisitorDot() {
    }

    public VisitorDot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
