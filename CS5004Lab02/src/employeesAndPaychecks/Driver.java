package employeesAndPaychecks;

/*
Name: Xuedinan Gao
Semester: Spring 2024
Assignment: CS5004Lab02

*/

public class Driver {
	
	// this is the test case provided by course
	public static void providedTestCase() throws Exception {
		//Create three employee objects
		Employee employee1 = new Employee("John", 20);
		Employee employee2 = new Employee("Max", 17);
		Employee employee3 = new Employee("Gary", 13.75);
		
		//Exception test 1
		Employee employee4 = new Employee("Jane", 98.78);
		Paychecks paycheck = new Paychecks();
		paycheck.loadCheck(employee4);
		
		//If these lines are in use they should throw the associated errors:
		
		//Exception in thread "main" java.lang.NullPointerException: Attempted pay generation with a null check object
		employee4.getWeeklyPay(null);
		
		//Exception in thread "main" java.lang.NullPointerException: Attempted a check load with a null employee object
		paycheck.loadCheck(null);
		
		//Exception test 2
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: Invalid Pay Rate.
		Employee badEmployee = new Employee("Bob", -34.98);
		
		//Demonstrate the successful construction of the three employees
		System.out.println("Printing Employees After Construction :");
		System.out.printf(employee1 + "\n" + employee2 + "\n" +  employee3 + "\n");
		
		//Demonstrate changing the hours and pay rate fields of an employee
		employee1.addHoursWorked(50);
		
		//Exception test 3
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: You cannot add negative hours.""
		employee1.addHoursWorked(-20);
		
		
		employee1.payRaise(10);
		
		//Exception test 4
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: You cannot give a negative raise. Use pay cut."
		employee1.payRaise(-10);
		
		System.out.println("Employee 1, with 50 hours and a 10% pay raise :");
		System.out.printf(employee1 + "\n");
		
		//Demonstrate construction & printing the paychecks 
		//of the three employees
		Paychecks paycheck1 = employee1.getWeeklyPay();
		Paychecks paycheck2 = employee2.getWeeklyPay();
		Paychecks paycheck3 = employee3.getWeeklyPay();
		
		System.out.println("Employee Weekly Paychecks :");
		System.out.printf(paycheck1 + "\n\n" + paycheck2 + "\n\n" +  paycheck3 + "\n\n");
		
		//Demonstrate that the employee objects reset their hoursWorked field
		//after they called the getWeeklyPay method
		System.out.println("Employee 1 with newly reset hours :");
		System.out.printf(employee1 + "\n");
	}
	
/*	

In this program I have functions as below;

Employee --

	- constructors
	- setters for name, payRate, hours
	- getters for name, payRate, hours, ID, total employee number
	- get weekly pay, get weekly pay(paycheck)
	- payRaise, payDecrease
	- addHours, resetHours
	- toString

Paychecks --

	- constructors
	- load check
	- helpers for calculation totalPay, overtime
	- setters for name, payRate, hours, overtime
	- getters for name, payRate, hours, overtime, totalPay
	- addHours
	- toString

My test case will be based on total pay;

1. Create test objective for each constructor
	- Employee: 2 arguments, invalid argument
	- Paychecks: 4 arguments, no argument, employee argument, invalid argument

2. Add hours
3. Check total pay
4. Increase payRate
5. Check total pay
6. Decrease payRate
7. Check total pay
8. Get weekly paycheck
9. Add overtime hours
10. Check total pay
11. Reset hours
12. Add hours < 40 and add overtime, check conflict
13. Check total employee numbers
14. Check total paychecks for this week
	
*/	
	public static void myTestCase() throws Exception{
		
	Employee ep1 = new Employee("Oku", 25.5);
	Employee ep2 = new Employee("Season", 35);
	Employee teste = new Employee("test", -1);
	
	//Constructor with Paychecks(String name, double payRate, int emID, double hoursWorked)
	Paychecks pc0 = new Paychecks("Tom", 30, 3, 60);
	Paychecks pc1 = new Paychecks(ep1);
	Paychecks pc2 = new Paychecks(ep2);
	Paychecks pc3 = new Paychecks();
	Paychecks testp = new Paychecks(teste);
	
	System.out.println("\n------ Start test -----\nThis is orginal information\n");
	System.out.printf(ep1 + "\n" + ep2 + "\n");
		
	System.out.printf("----- Add hours on Oku and Season -----\n");
	pc1.addHoursWorked(40);
	pc2.addHoursWorked(60);
	System.out.printf(ep1 + "\n" + ep2 + "\n");
	
	System.out.printf("----- Get total pay for Oku and Season -----\n");
	System.out.printf("Oku's total pay: $" + pc1.getTotalPay() + "\n");
	System.out.printf("Season's total pay: $" + pc2.getTotalPay() + "\n");
	
	System.out.printf("\n----- Get weekly paycheck for Oku and Season -----\n");
	Paychecks ep1pc = ep1.getWeeklyPay();
	Paychecks ep2pc = ep2.getWeeklyPay();
	System.out.printf(ep1pc + "\n" + ep2pc + "\n");
	
	System.out.printf("----- Increase pay rate for Oku and Season -----\n");
	ep1.payRaise(1.1);
	ep2.payRaise(1.5);
	pc1.payRate = ep1.getPayRate();
	pc2.payRate = ep2.getPayRate();
	System.out.printf("Oku's total pay: $" + pc1.getTotalPay() + "\n");
	System.out.printf("Season's total pay: $" + pc2.getTotalPay() + "\n");
	
	System.out.printf("\n----- Decrease pay rate for Oku and Season -----\n");
	ep1.payDecrease(0.2);
	ep2.payDecrease(0.5);
	pc1.payRate = ep1.getPayRate();
	pc2.payRate = ep2.getPayRate();
	System.out.printf("Oku's total pay: $" + pc1.getTotalPay() + "\n");
	System.out.printf("Season's total pay: $" + pc2.getTotalPay() + "\n");
	
	System.out.printf("\n----- Current paycheck for Tom -----\n");
	System.out.printf(pc0 + "\n");
	
	System.out.printf("----- Add overtime hours for Tom -----\n");
	pc0.setOverTime(100);;
	System.out.printf(pc0 + "\n");
	
	System.out.printf("----- Reset hours on Oku and Season -----\n");
	ep1.resetHoursWorked();
	ep2.resetHoursWorked();
	System.out.printf(ep1 + "\n" + ep2 + "\n");
	
	System.out.printf("----- Add invalid hours on Oku and Season -----\n");
	ep1.addHoursWorked(-100);
	ep2.addHoursWorked(-100);
	System.out.printf(ep1 + "\n" + ep2 + "\n");
	
	System.out.printf("----- We have total %d employees -----\n", Employee.getNumEmployees());
	System.out.printf("----- We could check employees paychecks by array list -----\n");
	
	System.out.println("\nEmployee assigned paycheck Array List is: \n" + "\n" +Employee.getAllPaycheck());
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//provided test case, all passed
		// providedTestCase();
		
		// my own test case, all passed
		myTestCase();
	}

}
