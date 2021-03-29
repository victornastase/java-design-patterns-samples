package com.java.learn.design.patterns.behavioral.state;

/**
 * Context class
 */
public class AlertContext {
    //field to store the current state
    private MobileAlert currentState;

    public AlertContext() {
        //initialize with a state
        this.currentState = new Vibration();
    }

    public void setCurrentState(MobileAlert currentState) {
        this.currentState = currentState;
    }

    public void alert() {
        currentState.alert(this);
    }
}
