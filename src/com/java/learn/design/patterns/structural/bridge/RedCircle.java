package com.java.learn.design.patterns.structural.bridge;

/*
    Concrete bridge implementer class.
 */
public class RedCircle implements Draw {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
