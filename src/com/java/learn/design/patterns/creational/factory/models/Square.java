package com.java.learn.design.patterns.creational.factory.models;

import com.java.learn.design.patterns.creational.factory.models.Shape;

/*
    Derivative Square
    Concrete class implementing Shape interface
 */
public class Square implements Shape {
    @Override
    public void whoAmI() {
        System.out.println("I'm a SQUARE!");
    }
}
