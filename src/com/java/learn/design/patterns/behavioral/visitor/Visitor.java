package com.java.learn.design.patterns.behavioral.visitor;

/**
 * Common visitor interface
 */
public interface Visitor {
    String visitDot(VisitorDot dot);

    String visitCircle(VisitorCircle circle);

    String visitRectangle(VisitorRectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);

}
