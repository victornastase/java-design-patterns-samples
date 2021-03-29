package com.java.learn.design.patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * Used for obtaining right Iterator for desired structure.
 * Keep in mind that you can have multiple ways for iteration, that's why an interface like this is a good practice.
 *
 * SRP&OCP: see SOLID principles (OOD).
 */
public interface IterableNameContainer {
    Iterator<String> getIterator();
}
