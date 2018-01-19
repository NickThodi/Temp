package com.Aditya.Employee;

import java.util.Date;

public class EmployeeHelper {

	Employee employee = null;

	public EmployeeHelper(Employee employee)
	{
		this.employee = employee;
	}
	
/*	public void salaryIncrement()
	{
	 float salaryinc = (float) (employee.getSalary() + (employee.getSalary() * 0.2));
	 employee.setSalary(salaryinc);
	 System.out.println("\nThe incremented salary is: "+salaryinc);
	}*/
	
  /*  public void findService(Employee ob1) 
	{
		Date d = new Date();
		long x = (d.getTime()- ob1.getDoj().getTime())/(1000*60*60*24);
		long year = (x/365);
		x = x % 365;
		long month = (x/30);
		x = x % 30;
		long day = (x-month+1);
		System.out.println("Employee "+ob1.getName()+" has worked for "+year+" years " +month+ " months and "+day+" days\n");
	}
	
	public void compareEmployee(Employee e1, Employee e2)
	{ 
		
		if(e1.getDoj().compareTo(e2.getDoj())<0)
	    {
	         System.out.println("Employee "+e1.getName()+" is senior than "+e2.getName());
		}
		else
		{
			 System.out.println("Employee "+e2.getName()+" is senior than "+e1.getName());
		}
		
	}*/
}

