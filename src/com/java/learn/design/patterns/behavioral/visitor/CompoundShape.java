package com.java.learn.design.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements VisitorShape {
    public int id;
    public List<VisitorShape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(VisitorShape shape) {
        children.add(shape);
    }

    public int getId() {
        return id;
    }
}
