package com.java.learn.design.patterns.behavioral.state;

/**
 * State implementation
 */
public class Vibration implements MobileAlert {
    @Override
    public void alert(AlertContext context) {
        System.out.println("vibration...");
    }
}
