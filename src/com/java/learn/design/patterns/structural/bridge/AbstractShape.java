package com.java.learn.design.patterns.structural.bridge;

public abstract class AbstractShape {
    protected Draw draw;

    protected AbstractShape(Draw draw) {
        this.draw = draw;
    }

    public abstract void draw();
}
