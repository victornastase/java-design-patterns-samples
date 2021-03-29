package com.java.learn.design.patterns.structural.decorator;

import java.io.FileNotFoundException;

/**
 * The component interface defines operations that can be
 * altered by decorators.
 */
public interface DataSource {
    void writeData(String data) throws FileNotFoundException;
    String readData();
}
