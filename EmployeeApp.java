package com.Aditya.Employee;

import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    
    
     
   /* e1= e1.setEmployeeInformation(101, "Aditya", 6000, e1.getDate(2016, 01, 04));
    e2= e2.setEmployeeInformation(204, "Anusha", 5999, e2.getDate(2016, 02, 04));*/
     
    //e1 = EmployeeUtil.constructEmployee(101, "Aditya", 6000, 27, e1.getDate(2016));
    //e2 = EmployeeUtil.constructEmployee(204, "Anusha", 5999, 28, e2.getDate(2015));
    
    EmployeeUtil.displayEmployeeInformation(e1);
    EmployeeUtil.displayEmployeeInformation(e2);
    
    System.out.println(EmployeeUtil.getHighestSalary(e1, e2));
    System.out.println(EmployeeUtil.constructEmployeeObject(e1));
     
    
    EmployeeHelper eh = new EmployeeHelper(e1);
    
   // eh.salaryIncrement();
    
   /* ASSIGNMENT-1 eh.compareEmployee(e1, e2);
    
    eh.findService(e1);
    eh.findService(e2);                  ASSIGNMENT-1 */
    
    System.out.println("---------------------Assignment-2------------------------------\n");
    
    EmployeeUtil.olderEmployee(e1, e2);
    EmployeeUtil.calculateDAandHRAandGross(e1);
    
    System.out.println("\nEnter the Department number 10/20/30/40");
    Scanner sc = new Scanner(System.in);
   // DepartmentEnum.getType(sc.nextInt());
    
    
    
	}

}
