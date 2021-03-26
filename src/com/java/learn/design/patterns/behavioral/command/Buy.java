package com.java.learn.design.patterns.behavioral.command;

/**
 * Concrete class implementing a command.
 *
 * SENDER
 */
public class Buy implements Order {
    private MarketTransaction transaction;

    public Buy(MarketTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void execute() {
        System.out.println("BUY ORDER processed: " + this.transaction.getStockName() + "," + this.transaction.getQuantity() + " items.");
    }
}
