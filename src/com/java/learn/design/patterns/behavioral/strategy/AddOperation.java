package com.java.learn.design.patterns.behavioral.strategy;

/**
 * Concrete strategy class.
 *
 * Define the algorithm of the operation.
 */
public class AddOperation implements MathOperationsStrategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
