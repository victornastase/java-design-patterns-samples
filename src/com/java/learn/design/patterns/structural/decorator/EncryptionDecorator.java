package com.java.learn.design.patterns.structural.decorator;

import java.io.FileNotFoundException;
import java.util.Base64;

/**
 * Concrete decorators must call methods on the wrapped object,
 * but may add something of their own to the result. Decorators
 * can execute the added behavior either before or after the
 * call to a wrapped object.
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) throws FileNotFoundException {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
