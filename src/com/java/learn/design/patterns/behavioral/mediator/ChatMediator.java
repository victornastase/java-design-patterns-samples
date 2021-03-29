package com.java.learn.design.patterns.behavioral.mediator;

/**
 * Mediator interface.
 *
 * The contract for concrete mediators.
 */
public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
