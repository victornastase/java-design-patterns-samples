package com.java.learn.design.patterns.structural.composite;

import java.util.List;

/**
 * Component container
 */
public class CompanyDirector implements Employee {
    private String name;
    private List<Employee> employees;

    public CompanyDirector(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Override
    public void showDetails() {
        System.out.println("CEO " + this.name + " has:");
        for(Employee e : this.employees) {
            e.showDetails();
        }
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }
}
