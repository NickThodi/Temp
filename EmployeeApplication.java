package com.Aditya.Employee;

import java.io.File;
import java.util.Scanner;

public class EmployeeApplication {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int size = 0;

		System.out.println("Set the size of the Array: ");

		size = input.nextInt();

		EmployeeArrayOperationsImpl eaoi = new EmployeeArrayOperationsImpl(size);

		File inputFile = new File("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");
		Employee[] arrEmp = eaoi.readCSV(inputFile);
		for (int i = 0; i < arrEmp.length; i++) {
			if (arrEmp[i] != null) {
				eaoi.createEmployee(arrEmp[i]);
			}
		}

		while (true) {
			eaoi.displayMenu();
			String choice = input.next();

			switch (choice) {
			case "a":
				System.out.println("Enter the following employee details");
				eaoi.createEmployee(EmployeeUtil.getValueFromUser());
				break;

			case "b":
				System.out.println("Enter the employee Id: ");
				int empid = input.nextInt();
				EmployeeUtil.displayUtil(eaoi.findEmployee(empid));
				break;

			case "c":
				System.out.println("Enter employee name: ");
				String name = input.next();
				EmployeeUtil.displayUtil(eaoi.findEmployee(name));
				break;

			case "d":
				System.out.println("Enter the id of the employee you want to delete: ");
				int Id = input.nextInt();
				eaoi.deleteEmployee(Id);
				System.out.println("Employee deleted!");
				break;

			case "e":
				System.out.println("Enter the id of the employee you want to update");
				int empId = input.nextInt();
				eaoi.updateEmployee(EmployeeUtil.getValueFromUser());
				break;

			case "f":
				System.out.println("Enter the employee id to calculate gross salary: ");
				int empsal = input.nextInt();
				eaoi.calculateGrossSal(empsal);
				break;

			case "g":
				eaoi.display();
				break;

			case "h":
				EmployeeUtil.regexCounter(inputFile);
				break;

			case "i":
				eaoi.writeCSV();
				System.out.println("File overwritten succefully!");
				System.exit(0);
				break;
			}
		}

	}
}
