package com.java.learn.design.patterns.behavioral.command;

/**
 * Concrete class implementing a command.
 *
 */
public class Sell implements Order {
    private MarketTransaction transaction;

    public Sell(MarketTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void execute() {
        System.out.println("SELL ORDER processed: " + this.transaction.getStockName() + "," + this.transaction.getQuantity() + " items.");
    }
}
