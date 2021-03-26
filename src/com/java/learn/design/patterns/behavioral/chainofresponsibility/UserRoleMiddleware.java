package com.java.learn.design.patterns.behavioral.chainofresponsibility;

/**
 * ConcreteHandler. Checks a user's role.
 */
public class UserRoleMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }

        System.out.println("Hello, user!");
        return checkNext(email, password);
    }

}
