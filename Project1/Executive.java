/*
 * Executive.java
 * Author: Aaron Wilcoxon
 * FileName:EmployeeData
 * Date: 21 Jan 2017
 *
 * Executive is a subclass of the Employee class.
 * This class appends stockPrice to the Employee builder and calculates
 * Executive salary based on default Employee AnnualSalary + a  bonus if
 * stockPrice is high enough.
 *
 *
 */
public class Executive extends Employee {

    private float stockPrice;

    public Executive() {
        super();
        stockPrice = 10;
    }

    public Executive(String name, int monthlySalary,
        float stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = stockPrice;
    }

    public int AnnualSalary() {
        super.AnnualSalary();
        if (stockPrice >= 50) {
            annualSalary = super.annualSalary + 30000;
        }
        return annualSalary;
    }

    public String toString() {
        return super.toString() + " | Stock Price: $" + stockPrice;
    }

}
