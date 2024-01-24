package employeesAndPaychecks;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	Employee e1;
	Employee e2;
	Employee e3;

	
	@Before
	public void setUp() {
		
		e1 = new Employee("Jack", 30);
		e2 = new Employee("Lucy", 15);
		e3 = new Employee("Tom", 20);
		
	}
	
	//Getters and setters were requested. Let's check
	@Test //TODO1
	public void gettersAndSetters()
	{
		e1.setRateValue(40);
		e2.setName("Bobby");
		
		assertEquals(40,e1.getPayRate());
		assertEquals("Bobby",e2.getName());
		assertEquals(3,e3.getId());
	}

	// Constructor test
	@Test //TODO2
	public void testConstructor() {
		assertEquals(30,e1.getPayRate());
		assertEquals("Lucy",e2.getName());
		assertEquals(0,e3.getWorkHour());
	}
	
	// Add hours worked test
	@Test //TODO3
	public void testAddHoursWorked() {
		
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		
		assertEquals(100,e1.getWorkHour());
		assertEquals(50,e2.getWorkHour());
	}
	
	// Reset hours worked test
	@Test //TODO4
	public void testRestHoursWorked() {
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		
		assertEquals(100,e1.getWorkHour());
		assertEquals(50,e2.getWorkHour());
		
		e1.resetHoursWorked();
		e2.resetHoursWorked();
		
		assertEquals(0,e1.getWorkHour());
		assertEquals(0,e2.getWorkHour());
	}
	
	// Get weekly pay tests
	@Test //TODO5
	public void testGetWeeklyPay() {
		Paychecks pe1 = e1.getWeeklyPay();
		Paychecks pe2 = e2.getWeeklyPay();
		
		assertEquals("Jack",pe1.getName());
		assertEquals(15,pe2.getPayRate());
		assertEquals(0,e1.getWorkHour());
		assertEquals(0,e2.getWorkHour());
	}
	
	@Test //TODO6
	public void testGetWeeklyPayParameter() {
		
		Paychecks p1 = new Paychecks();
		Paychecks p2 = new Paychecks();
		
		Paycheck pe1 = e1.getWeeklyPay(p1);
		Paycheck pe1 = e2.getWeeklyPay(p2);
		
		assertEquals("Jack",pe1.getName());
		assertEquals(15,pe2.getPayRate());
		assertEquals(0,e1.getWorkHour());
		assertEquals(0,e2.getWorkHour());
	}
	
	// Pay raise tests
	@Test //TODO7
	public void testGetWeeklyPay() {
		e1.payRaise(1.1);
		e1.payRaise(1.2);
		
		assertEquals(33,e1.getPayRate());
		assertEquals(18,e2.getPayRate());
	}
	
	// Total employees number test
	@Test //TODO7
	public void testGetWeeklyPay() {
		assertEquals(3,Employee.getNumEmployees());
	}
}