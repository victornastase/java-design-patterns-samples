package com.java.learn.design.patterns.creational.factory;

import com.java.learn.design.patterns.creational.factory.models.Circle;
import com.java.learn.design.patterns.creational.factory.models.Rectangle;
import com.java.learn.design.patterns.creational.factory.models.Shape;
import com.java.learn.design.patterns.creational.factory.models.Square;

/**
    Factory Design Pattern

    OOD Principles:
    - Single Responsibility Principle: you move the core of creating objects in one place.
    - Open/Closed Principle: you can introduce new type of objects into the module without braking/touching existing code.

    Bad code/design symptoms which Factory resolves: RIGIDITY, FRAGILITY
 */
public class ShapeFactory {

    public Shape createShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else {
            return new Circle();
        }
    }

}
