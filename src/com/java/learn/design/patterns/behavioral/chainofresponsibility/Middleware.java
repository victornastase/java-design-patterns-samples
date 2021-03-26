package com.java.learn.design.patterns.behavioral.chainofresponsibility;

/**
 * Base middleware class.
 */
public abstract class Middleware {

    private Middleware next;

    //Builds the chain.
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    //Subclasses will implement this.
    public abstract boolean check(String email, String password);

    //Verify if the chain has more handlers.
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }

}
