/*
 * Employee.java
 * Author: Aaron Wilcoxon
 * FileName:EmployeeData
 * Date: 21 Jan 2017
 * Copyright 2017 Aaron Wilcoxon <Aaron Wilcoxon@HOSTNAME>
 *
 * Employee Class is default Class of Employee type.
 * This Class creates an Employee object with fields of name and
 * monthlySalary. The AnnualSalary method calculates the base annual salary of
 * the Employee object.
 */
public class Employee {

    protected String name;
    protected int monthlySalary;
    protected int annualSalary;

    public Employee() {
        name = null;
        monthlySalary = 0;
    }

    public Employee(String name, int monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public int AnnualSalary() {
        annualSalary = monthlySalary * 12;
        return annualSalary;
    }

    public String toString() {
        return "Name: " + name + " | Monthly Salary: $" + monthlySalary;
    }
}
