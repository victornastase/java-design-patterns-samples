package com.java.learn.design.patterns.structural.composite;

/**
 * Leaf
 */
public class Manager implements Employee {
    private String name;
    private String position;
    private long id;

    public Manager(String name, String position, long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee id: " + this.id + ", name: " + this.name + " , position: " + this.position);
    }
}
