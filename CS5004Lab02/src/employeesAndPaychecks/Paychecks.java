package employeesAndPaychecks;

public class Paychecks {
	
	String name;
	double payRate;
	double hoursWorked;
	
	double totalPay;
	double overTime;

	
	
	// constructor with 4 arguments
	
	public Paychecks(String name, double payRate, int emID, double hoursWorked) {
		
	try {	
		this.name = name;
		this.payRate = payRate;
		this.hoursWorked = hoursWorked;
		
		this.overTime = calOverTime(hoursWorked);
		this.totalPay = calTotalPay(hoursWorked);
		}
	catch(IllegalArgumentException e) {
			System.out.println("Input for employee's information is invalid");
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
	catch(IllegalArgumentException E) {
			System.out.println("Extracted employee's information is invalid");
		}
	}
	
	
	// a method to load information from a employee objective
	
	public void loadCheck(Employee e)throws Exception {
		
	try {	
		this.name = e.getName();
		this.payRate = e.getPayRate();
		this.hoursWorked = e.getHoursWorked();
		}
	catch(IllegalArgumentException er) {
			System.out.println("This is invlaid employee information");
		}
	}

	
	// calculate total pay
	
	private double calTotalPay(double hours) {
		
		double pay = 0;
		
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
	
	// calculate overtime
	
	private double calOverTime(double hours) {
		
		double otHours = 0;
		
		if(hoursWorked > 40) {
			otHours = hoursWorked - 40.0;
			return otHours;
		}
		else {
			return otHours; 
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

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getTotalPay() {
		
		return totalPay = calTotalPay(hoursWorked);		
	}

	public double getOverTime() {
		return overTime = calOverTime(hoursWorked);
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}

}
	
	

