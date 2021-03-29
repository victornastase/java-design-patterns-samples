package com.java.learn.design.patterns.behavioral.observer;

import java.io.File;

/**
 * Subscriber
 */
public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("E-mail to: " + this.email + ". Someone has performed " + eventType + " on the file " + file.getName());
    }
}
