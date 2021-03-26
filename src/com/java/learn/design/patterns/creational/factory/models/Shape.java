package com.java.learn.design.patterns.creational.factory.models;

/*
    Base type
    Note: to take advantage of Java polymorphism we define a interface as a base type.
    Responsibility 1: to tell what kind of shape it is (used in factory demo).
    Responsibility 2: display a shape (used in Adapter demo).
 */
public interface Shape {
    void whoAmI();
}
