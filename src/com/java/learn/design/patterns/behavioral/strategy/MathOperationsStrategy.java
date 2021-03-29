package com.java.learn.design.patterns.behavioral.strategy;

/**
 * Strategy interface.
 * Define the operation on some input with different algorithms.
 */
public interface MathOperationsStrategy {
    int doOperation(int a, int b);
}
