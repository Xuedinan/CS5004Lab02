package employeesAndPaychecks;

import java.util.ArrayList;
import java.util.List;

/*
Name: Xuedinan Gao
Semester: Spring 2024
Assignment: CS5004Lab02

*/

public class Employee {
	
	private String name;
	private double payRate;
	private double hoursWorked;
	private int emID;
	
	// first employee ID is 1
	private static int counter = 1;
	
	// Array list used to store Paychecks
	private static List<Paychecks> paycheckStore = new ArrayList<>();
	
	
	
	public Employee(String name, double payRate)throws Exception {
	
	try {
		
		if(payRate < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.payRate = payRate;
		this.hoursWorked = 0;
		emID = counter;
		counter++;
		}

	catch(IllegalArgumentException e) {
		System.out.println("Provided employee name or pay rate is invalid. \n" + e + "\n");
		}
	}

	// getters and setters
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPayRate() {
		return payRate;
	}



	public void setPayRate(double payRate)throws Exception {
	
	try {
		if(payRate < 0) {
			throw new IllegalArgumentException();
		}
	
		this.payRate = payRate;
		}
	catch(IllegalArgumentException E) {
		System.out.println("Set pay rate must be greater than 0 \n" + E + "\n");
		}
	}


	public double getHoursWorked() {
		return hoursWorked;
	}



	public void setHoursWorked(double hoursWorked) {
		
		try {
			if(hoursWorked < 0) {
				throw new IllegalArgumentException();
			}
		
			this.hoursWorked = hoursWorked;
			}
		catch(IllegalArgumentException E) {
			System.out.println("Set worked hours must be greater than 0 \n" + E + "\n");
			}
		}

	public int getEmID() {
		return emID;
	}

	
	// add worked hours, input must greater than 0
	public void addHoursWorked(double hours)throws Exception {
		
	try {	
		if (hours <= 0){	
			throw new IllegalArgumentException();
		}
		else {
		this.hoursWorked = hours + this.hoursWorked;
			}
		}
	catch(IllegalArgumentException iE) {
		System.out.println("Added worked hours must greater than 0. \n" + iE + "\n");
		}
	}
	
	// reset worked hours to 0
	public void resetHoursWorked() {
		this.hoursWorked = 0;
	}
	
	
	
	// generate paycheck for objective then reset hours worked
	public Paychecks getWeeklyPay() {
	
		Paychecks p = new Paychecks(this.name, this.payRate, this.emID, this.hoursWorked);
		resetHoursWorked();
		
		paycheckStore.add(p);
		return p;
	}
	
	
	//Receive a "blank" paycheck and assign it to this employee then reset hours
	public Paychecks getWeeklyPay(Paychecks paychecks)throws Exception {
		
	try {
		paychecks.name = this.name;
		paychecks.payRate = this.payRate;
		paychecks.hoursWorked = this.hoursWorked;
		
		resetHoursWorked();
		
		return paychecks;
		}
	catch(NullPointerException NE) {
		System.out.println("Receivied invalid paycheck in getWeeklyPay. \n" + NE + "\n");
		}
		
		paycheckStore.add(paychecks);
		return paychecks;
	}
	
	
	// method to increase pay rate
	public void payRaise(double increaseRate) {
	
	try {	
		if(increaseRate < 1) {
			throw new IllegalArgumentException();
			}
		this.payRate = this.payRate * increaseRate;

		}
	catch(IllegalArgumentException iE) {
			System.out.println("Increase rate must be greater than 1. e.g. Increase rate = 1.2 means increase rate by 20%.\n" + iE + "\n");
		}
	}
	
	
	// method to decrease pay rate 
	public void payDecrease(double decreaseRate) {
	
	try {	
		if(decreaseRate < 0 || decreaseRate >= 1) {
			throw new IllegalArgumentException();
			}
		this.payRate = this.payRate * (1 - decreaseRate);
		}
	catch(IllegalArgumentException iE) {
		System.out.println("Increase rate must be greater than 0 and less than 1. e.g. Decrease rate = 0.2 means decrease rate by 20%. \n" + iE + "\n");
		}
	}
	
	// get how many employees are created in total
	public static int getNumEmployees() {
		return counter;
	}
		
	public static List<Paychecks> getAllPaycheck() {
		return paycheckStore;
	}
		
	// print out employee information
	@Override
	public String toString() {
		
//		System.out.println("Employee Name: " + name + "\nEmployee Pay Rate: $" + payRate + "\nEmployee's Hours this week: " + hoursWorked + "\nEmployee ID: " + emID + "\n");
		return "Employee Name: " + name + "\nEmployee Pay Rate: $" + payRate + "\nEmployee's Hours this week: " + hoursWorked + "\nEmployee ID: " + emID + "\n";
	}
	
}	




