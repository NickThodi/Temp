package com.Aditya.Employee;

import java.util.Scanner;

public class EmployeeDBOprApp {

	public static void main(String[] args) throws InvalidSalaryException, Exception {
		EmployeeDBOperationsImpl edbo = new EmployeeDBOperationsImpl();
		EmployeeArrayOperationsImpl eaoi = new EmployeeArrayOperationsImpl();

		while (true) {
			eaoi.displayMenu();
			Scanner input = new Scanner(System.in);
			String choice = input.next();

			switch (choice) {

			case "a":
				edbo.createEmployee(EmployeeUtil.getValueFromUser());
				System.out.println("Employee added successfully.");
				break;

			case "b":
				System.out.println("Enter the employee number: ");
				int empid = input.nextInt();
				edbo.findEmployee(empid);
				break;

			case "c":
				System.out.println("Enter employee name: ");
				String name = input.next();
				edbo.findEmployee(name);
				break;

			case "d":
				System.out.println("Enter the id of the employee you want to delete: ");
				int Id = input.nextInt();
				edbo.deleteEmployee(Id);
				System.out.println("Employee deleted!");
				break;

			case "e":
				System.out.println("Enter the following details:");
				edbo.updateEmployee(EmployeeUtil.getValueFromUser());
				break;

			case "f":
				System.out.println("Enter the employee id to calculate gross salary: ");
				int emplId = input.nextInt();
				edbo.calculateGrossSal(emplId);
				break;

			case "g":
				edbo.display();
				break;

			case "h":
				System.out.println("Enter sorting criterion");
				System.out.println("press 1: Sort by Name");
				System.out.println("press 2: Sort by Age and Salary");

				int num = input.nextInt();

				switch (num) {
				case 1:
					edbo.sortDataByName();
					break;

				case 2:
					edbo.sortDataByAgeSalary();
					break;

				default:
					System.exit(0);
					System.out.println("Wrong Input!");
					break;
				}
				break;

			case "i":
				edbo.getUniqueNames();
				break;

			case "j":
				edbo.getEmployeeCount();
				break;

			case "k":
				System.exit(0);
				break;

			}
		}
	}
}
