package com.java.learn.design.patterns.behavioral.command;

/**
 * Receiver class.
 */
public class MarketTransaction {
    private String stockName;
    private int quantity;

    public MarketTransaction(String productName, int quantity) {
        this.stockName = productName;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }
}
