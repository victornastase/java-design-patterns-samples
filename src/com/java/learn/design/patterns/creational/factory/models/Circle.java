package com.java.learn.design.patterns.creational.factory.models;

/*
    Derivative Rectangle
    Concrete class implementing Shape interface
 */
public class Circle implements Shape {
    @Override
    public void whoAmI() {
        System.out.println("I'm a CIRCLE!");
    }
}
