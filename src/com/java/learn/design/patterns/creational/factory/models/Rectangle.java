package com.java.learn.design.patterns.creational.factory.models;

/*
    Derivative Rectangle
    Concrete class implementing Shape interface
 */
public class Rectangle implements Shape {
    @Override
    public void whoAmI() {
        System.out.println("I'm a RECTANGLE!");
    }
}
