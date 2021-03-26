package com.java.learn.design.patterns.creational.singletone;

/**
 * A lot of developers consider the Singleton pattern an antipattern.
 *
 */
public class NaiveSingleton {
    //Add a private static field to the class for storing the singleton instance
    private static NaiveSingleton instance;

    public String value;

    //Make the constructor of the class private. The static method of the class will still be able to call the constructor, but not the other objects.
    private NaiveSingleton(String value) {
        this.value = value;
    }

    //Declare a public static creation method for getting the singleton instance
    public static NaiveSingleton getInstance(String value) {
        if(instance == null) {
            instance = new NaiveSingleton(value);
        }
        return instance;
    }
}
