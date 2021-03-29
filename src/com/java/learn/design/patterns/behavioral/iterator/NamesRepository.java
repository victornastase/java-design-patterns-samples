package com.java.learn.design.patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * Concrete collection.
 */
public class NamesRepository implements IterableNameContainer {
    public String names[] = { "Ajay", "Vijay", "Martin", "Racheal", "Kim" };

    @Override
    public Iterator<String> getIterator() {
        return new NamesRepositoryIterator(this);
    }
}
