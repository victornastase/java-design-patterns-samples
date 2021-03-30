package com.java.learn.design.patterns.behavioral.memento;

/**
 * Originator
 */
public class EmployeePerson {
    protected int empId;
    protected String name;
    protected String designation;
    protected long salary;
    protected String department;
    protected String project;

    public EmployeePerson(int empId) {
        super();
        this.empId = empId;
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
        return "EmplyeePerson{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", project='" + project + '\'' +
                '}';
    }

    public EmployeeMemento createMemento() {
        return new EmployeeMemento(empId, name, designation, salary, department, project);
    }

    public void restore(EmployeeMemento memento) {
        if(memento != null) {
            this.empId = memento.empId;
            this.name = memento.name;
            this.designation = memento.designation;
            this.salary = memento.salary;
            this.department = memento.department;
            this.project = memento.project;
        } else {
            System.err.println("Can't restore without memento object!");
        }
    }
}
