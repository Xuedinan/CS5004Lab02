package employeesAndPaychecks;

public class Employee {
	
	private String name;
	private double payRate;
	private double hoursWorked;
	private int emID;
	
	private static int counter = 0;
	
	
	
	public Employee(String name, double payRate) {

		this.name = name;
		this.payRate = payRate;
		this.hoursWorked = 0;
		emID = counter;
		
		counter++;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPayRate() {
		return payRate;
	}



	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}



	public double getHoursWorked() {
		return hoursWorked;
	}



	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}



	public int getEmID() {
		return emID;
	}

	
	public void addHoursWorked(double hours) {
		
		if (hours > 0){
		this.hoursWorked = hours + this.hoursWorked;
		}
		else {
			System.out.println("Added worked hours must greater than 0. ");
		}
	}	
	
	public void resetHoursWorked() {
		this.hoursWorked = 0;
	}
	
	
	
	// generate paycheck for objective then reset hours worked
	public Paychecks getWeeklyPay() {
		
		Paychecks p = new Paychecks(this.name, this.payRate, this.emID, this.hoursWorked);
		resetHoursWorked();
		
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
		System.out.println("Receivied invalid paycheck. ");
		}
		return paychecks;
	}
	
	public void payRaise(double increaseRate) {
		this.payRate = this.payRate * increaseRate;
	}
	
	public static int getNumEmployees() {
		return counter;
	}
		
}	




