/*
 * Author: Aaron Wilcoxon
 * FileName:EmployeeData
 * Date: 21 Jan 2017
 *
 * EmployeeData is main Class for EmployeeData program.
 * This program reads in a filename as argument and scans and imports each line based
 * on data the line contains. Data gets imported into arrays of Employee type and
 * all data is printed in readable format.
 *File input must be formatted as follows:
 * 2014 Employee Smith,John 2000
 * 2015 Salesman Jones,Bill 3000 100000
 * 2014 Executive Bush,George 5000 55
 * 2014 Salesman Jones,Bill 3000 100000
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeData {

    public static void main(String[] args) throws IOException {

        int k = 0;
        int j = 0;
        int i = 0;
        int h = 0;
        int year2014Sales = 0;
        int year2015Sales = 0;
        int year2014Salary = 0;
        int year2015Salary = 0;
        int average2014Salary = 0;
        int average2015Salary = 0;

        Scanner fileInput = new Scanner(new File(args[0]));

        Employee[] year2014 = new Employee[10];
        Employee[] year2015 = new Employee[10];

        String oneLine;
        String[] fileInfo = new String[5];

        while (fileInput.hasNext()) {
            oneLine = fileInput.nextLine();
            fileInfo = oneLine.split(" ");

            if (fileInfo[0].equals("2014")) {
                if (fileInfo[1].equals("Employee")) {
                    year2014[k] = new Employee(fileInfo[2], Integer.valueOf(fileInfo[3]));
                } else if (fileInfo[1].equals("Executive")) {
                    year2014[k] = new Executive(fileInfo[2], Integer.valueOf(fileInfo[3]),
                            Integer.valueOf(fileInfo[4]));
                } else if (fileInfo[1].equals("Salesman")) {
                    year2014[k] = new Salesman(fileInfo[2], Integer.valueOf(fileInfo[3]),
                            Integer.valueOf(fileInfo[4]));
                    year2014Sales = year2014Sales + Integer.valueOf(fileInfo[4]);
                }
                year2014Salary = year2014Salary + year2014[k].AnnualSalary();
                k++;
                average2014Salary = year2014Salary / k;
            }

            if (fileInfo[0].equals("2015")) {
                if (fileInfo[1].equals("Employee")) {
                    year2015[j] = new Employee(fileInfo[2], Integer.valueOf(fileInfo[3]));
                } else if (fileInfo[1].equals("Executive")) {
                    year2015[j] = new Executive(fileInfo[2], Integer.valueOf(fileInfo[3]),
                            Integer.valueOf(fileInfo[4]));
                } else if (fileInfo[1].equals("Salesman")) {
                    year2015[j] = new Salesman(fileInfo[2], Integer.valueOf(fileInfo[3]),
                            Integer.valueOf(fileInfo[4]));
                    year2015Sales = year2015Sales + Integer.valueOf(fileInfo[4]);
                }
                year2015Salary = year2015Salary + year2015[j].AnnualSalary();
                j++;
                average2015Salary = year2015Salary / j;

            }

        }

        System.out.println("Year 2014 Summary:");
        System.out.println("__________________________________________________________________");
        for (i = 0; i < year2014.length; i++) {
            if (year2014[i] != null) {
                System.out.println(year2014[i] + "\n");
            }
        }
        System.out.println("2014 Salary: $" + year2014Salary);
        System.out.println("Average Salary: $" + average2014Salary);
        System.out.println("2014 Sales: $" + year2014Sales);
        System.out.println("__________________________________________________________________");

        System.out.println("Year 2015 Summary:");
        System.out.println("__________________________________________________________________");
        for (i = 0; i < year2015.length; i++) {
            if (year2015[i] != null) {
                System.out.println(year2015[i] + "\n");
            }
        }
        System.out.println("2015 Salary: $" + year2015Salary);
        System.out.println("Average Salary: $" + average2015Salary);
        System.out.println("2015 Sales: $" + year2015Sales);

    }
}
