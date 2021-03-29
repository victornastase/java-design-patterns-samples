package com.java.learn.design.patterns.behavioral.strategy;

/**
 * Context class. Store the strategy.
 */
public class MathContext {
    private MathOperationsStrategy strategy;

    public MathContext(MathOperationsStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeOperation(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
