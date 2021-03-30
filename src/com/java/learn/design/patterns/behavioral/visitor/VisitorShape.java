package com.java.learn.design.patterns.behavioral.visitor;

public interface VisitorShape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
