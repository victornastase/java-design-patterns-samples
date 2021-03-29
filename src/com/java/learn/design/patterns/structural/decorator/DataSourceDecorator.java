package com.java.learn.design.patterns.structural.decorator;

import java.io.FileNotFoundException;

/**
 * Abstract base decorator.
 *
 * The base decorator class follows the same interface as the
 * other components. The primary purpose of this class is to
 * define the wrapping interface for all concrete decorators.
 * The default implementation of the wrapping code might include
 * a field for storing a wrapped component and the means to
 * initialize it.
 */
public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) throws FileNotFoundException {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
