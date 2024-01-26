package employeesAndPaychecks;

public class Driver {
	
	
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

So my test case will be based on total pay;

1. Create test objective for each constructor
	- Employee: 2 arguments, no argument, invalid argument
	- Paychecks: 4 arguments, no argument, employee argument, invalid argument

2. Add hours
3. Check total pay
4. Increase payRate
5. Check total pay
6. Decrease payRate
7. Check total pay
8. Add overtime
9. Check total pay
10. Reset hours
11. Add hours < 40 and add overtime, check conflict
12. Check total pay
13. Check total employee numbers
14. Check total paychecks for this week
	
*/	
	public static void myTestCase() throws Exception{
		
		
		
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		providedTestCase();
	}

}
