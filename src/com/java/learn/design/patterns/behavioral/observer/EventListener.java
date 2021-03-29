package com.java.learn.design.patterns.behavioral.observer;

import java.io.File;

/**
 * Common observer interface
 */
public interface EventListener {
    void update(String eventType, File file);
}
