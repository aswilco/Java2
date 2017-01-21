/*
 * Salesman.java
 * Author: Aaron Wilcoxon
 * FileName:EmployeeData
 * Date: 21 Jan 2017
 *
 * Salesman class is a subclass of Employee.
 * The Salesman class extends Employee by addinga commission value and
 * calculates the salary of the salesman object by importing the annualSalary
 * from the parent class and adding the commission.
 *
 *
 */
public class Salesman extends Employee {

    private int annualSales;
    private double commission;

    public Salesman() {
        super();
        annualSales = 5000;
    }

    public Salesman(String name, int monthlySalary,
        int annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    public int AnnualSalary() {
        super.AnnualSalary();
        if (.02 * annualSales <= 20000) {
            annualSalary = (int) Math.round(.02 * annualSales + super.annualSalary);
        } else {
            annualSalary = super.annualSalary + 20000;
        }
        return annualSalary;
    }

    public String toString() {
        return super.toString() + " | Annual Sales: $"
        + annualSales;
    }

}
