package employeesAndPaychecks;

/*
Name: Xuedinan Gao
Semester: Spring 2024
Assignment: CS5004Lab02

*/

public class Paychecks {
	
	String name;
	double payRate;
	double hoursWorked;
	int emID;
	
	double totalPay;
	double overTime;
	
	
	// constructor with 4 arguments
	
	public Paychecks(String name, double payRate, int emID, double hoursWorked) {
		
	try {	
		this.name = name;
		this.payRate = payRate;
		this.hoursWorked = hoursWorked;
		this.emID = emID;
		
		this.overTime = calOverTime(hoursWorked);
		this.totalPay = calTotalPay(hoursWorked);
		}
	catch(Exception e) {
			System.out.println("Input for employee's information is invalid\n"+ e + "\n");
		}
	}

	public Paychecks() {
	}

	// constructor with Employee objective as argument
	
	public Paychecks(Employee e) {
		
	try {
		this.name = e.getName();
		this.payRate = e.getPayRate();
		this.hoursWorked = e.getHoursWorked();

			this.overTime = calOverTime(hoursWorked);
			this.totalPay = calTotalPay(hoursWorked);
		}
	catch(Exception E) {
			System.out.println("Extracted employee's information is invalid" + E + "\n");
		}
	}
	
	
	// a method to load information from a employee objective
	
	public void loadCheck(Employee e)throws Exception {
		
	try {	
		this.name = e.getName();
		this.payRate = e.getPayRate();
		this.hoursWorked = e.getHoursWorked();
		}
	catch(NullPointerException er) {
			System.out.println("Received invalid employee information when try to load check. \n" + er + "\n");
		}
	}

	
	// calculate total pay
	
	private double calTotalPay(double hours) {
		
		double pay = 0;
		
	try {
		if(hours > 40) {
			pay = (hours - 40) * 1.5 * payRate + 40 * payRate;
			return pay;
		}
		else if(hours > 0 || hours < 40.0) {
			pay = hours * payRate;
			return pay;
		}
		else {
			System.out.println("Hours must be greater than 0. ");
			
			return -999.99;
			}
		}
	catch(IllegalArgumentException iE) {
		throw new IllegalArgumentException("Given worked hours is wrong for calcualting total pay " + iE + "\n");
		}
	}
	
	
	// calculate overtime
	
	private double calOverTime(double hours) {
		
		double otHours = 0;
	try {
		if(hoursWorked >= 40) {
			otHours = hoursWorked - 40.0;
			return otHours;
		}
		else {
			return otHours; 
		}
	}
	catch(IllegalArgumentException iE) {
		throw new IllegalArgumentException("Given worked hours is wrong for calcualting overtime hours " + iE + "\n");
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
	
	// set pay rate must be greater than 0
	public void setPayRate(double payRate) {
		
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

	// set worked hours must be greater than 0
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
	
	// get total pay by calculation method
	public double getTotalPay() {
		return totalPay = calTotalPay(hoursWorked);		
	}
		
	// get overtime hours by calculation method
	public double getOverTime() {
		return overTime = calOverTime(hoursWorked);
	}
	
	// set overtime hours
	public void setOverTime(double overTime) {
	
	try {
		if(overTime < 0) {
			throw new IllegalArgumentException();
		}
		else if(hoursWorked < 40) {
			this.overTime = 0;
		}
		else {
			this.overTime = overTime;
			this.hoursWorked = 40 + overTime;
			this.totalPay = calTotalPay(hoursWorked);
			}
		}
	catch(IllegalArgumentException E) {
		System.out.println("Set overtime hours must be greater than 0 \n" + E + "\n");
		}
	}
	
	
	// add hours worked
	public void addHoursWorked(double hours)throws Exception {
		
	try {	
		if (hours <= 0){	
			throw new IllegalArgumentException();
		}
		else {
		this.hoursWorked = hours + this.hoursWorked;
		this.totalPay = calTotalPay(hoursWorked);
			}
		}
	catch(IllegalArgumentException iE) {
		System.out.println("Added worked hours must greater than 0. \n" + iE + "\n");
		}
	}
	
	// print out paycheck information
	@Override
	public String toString() {
		
//		System.out.println("Employee " + name+ "'s Paycheck. ID# : " + emID + "\nPay Rate: $" + payRate + "\nWorked Hours: " + hoursWorked + "\nOvertime hours: " + overTime + "\nTotal Pay: $" + totalPay + "\n");
		return "Employee " + name+ "'s Paycheck. ID# : " + emID + "\nPay Rate: $" + payRate + "\nWorked Hours: " + hoursWorked + "\nOvertime hours: " + overTime + "\nTotal Pay: $" + totalPay + "\n";
	}

}
	
	

