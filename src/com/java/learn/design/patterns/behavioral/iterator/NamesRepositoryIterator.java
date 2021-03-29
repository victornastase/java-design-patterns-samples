package com.java.learn.design.patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * The iterator algorithm.
 *
 * We use here Java Iterator interface.
 * But this is not a rule: with a custom interface works as well.
 * The idea behind is to use an interface for iteration algorithm, in which you have to define the iterable operations;
 * in this case Java Iterator works just fine!
 */
public class NamesRepositoryIterator implements Iterator<String> {
    private int currentElement = 0;
    private NamesRepository namesRepository;

    public NamesRepositoryIterator(NamesRepository namesRepository) {
        this.namesRepository = namesRepository;
    }

    @Override
    public boolean hasNext() {
        if(currentElement < namesRepository.names.length)
            return true;
        return false;
    }

    //TODO: throw exception here!
    //don't ever return NULL in real-life software!
    @Override
    public String next() {
        if(this.hasNext()) {
            return namesRepository.names[currentElement++];
        }
        return null;
    }
}
