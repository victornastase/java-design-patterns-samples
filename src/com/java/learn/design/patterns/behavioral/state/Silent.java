package com.java.learn.design.patterns.behavioral.state;

/**
 * State implementation
 */
public class Silent implements MobileAlert {
    @Override
    public void alert(AlertContext context) {
        System.out.println("silent...");
    }
}
