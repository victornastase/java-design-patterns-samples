package com.java.learn.design.patterns.creational.prototype;

/**
 * Simple shape
 */
public class Triangle extends Shape {
    private int base;

    public Triangle() {
    }

    public Triangle(Triangle triangle) {
        super(triangle);
        this.base = triangle.base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public Shape clone() {
        return new Triangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if(!(object2 instanceof Triangle) || !super.equals(object2)) return false;
        Triangle shape2 = (Triangle) object2;
        return shape2.base == base;
    }
}
