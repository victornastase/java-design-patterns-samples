package com.java.learn.design.patterns.behavioral.memento;

/**
 * Memento
 * POJO OBJECT
 */
public class EmployeeMemento {
    protected int empId;
    protected String name;
    protected String designation;
    protected long salary;
    protected String department;
    protected String project;

    public EmployeeMemento(int empId, String name, String designation, long salary, String department, String project) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
        this.project = project;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "EmployeeMemento{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", project='" + project + '\'' +
                '}';
    }
}
