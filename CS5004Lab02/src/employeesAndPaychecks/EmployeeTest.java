package employeesAndPaychecks;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	
	Employee e1 = new Employee("Jack", 30.0);
	Employee e2 = new Employee("Lucy", 15.0);
	Employee e3 = new Employee("Tom", 20.0);
	
	//Getters and setters tests
	@Test
	public void gettersAndSetters()
	{
		e1.setPayRate(40.0);
		e2.setName("Bobby");
		
		assertEquals("Bobby",e2.getName());
		assertEquals(40.0,e1.getPayRate(), 0.001);
	}
	
	// Constructor test
	@Test
	public void testConstructor() {
		assertEquals(0, e1.getHoursWorked(), 0.001);
		assertEquals("Lucy",e2.getName());
		assertEquals(30.0, e1.getPayRate(), 0.001);
		
	}
	
	// Add hours worked test
	@Test 
	public void testAddHoursWorked() {
		
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		e3.addHoursWorked(-1); // this will print out reminder message
		
		assertEquals(100,e1.getHoursWorked(), 0.001);
		assertEquals(50,e2.getHoursWorked(), 0.001);
		assertEquals(0,e3.getHoursWorked(), 0.001);
	}
	

	// Reset hours worked test
	@Test //TODO4
	public void testRestHoursWorked() {
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		
		assertEquals(100,e1.getHoursWorked(), 0.001);
		assertEquals(50,e2.getHoursWorked(), 0.001);
		
		e1.resetHoursWorked();
		e2.resetHoursWorked();
		
		assertEquals(0,e1.getHoursWorked(), 0.001);
		assertEquals(0,e2.getHoursWorked(), 0.001);
	}
	
	/*
	// Get weekly pay tests
	@Test //TODO5
	public void testGetWeeklyPay() {
		Paychecks pe1 = e1.getWeeklyPay();
		Paychecks pe2 = e2.getWeeklyPay();
		
		assertEquals("Jack",pe1.getName());
		assertEquals(15.0,pe2.getPayRate());
		assertEquals(0,e1.getHoursWorked());
		assertEquals(0,e2.getHoursWorked());
	}
	
	@Test //TODO6
	public void testGetWeeklyPayParameter() {
		
		Paychecks p1 = new Paychecks();
		Paychecks p2 = new Paychecks();
		
		Paychecks pe1 = e1.getWeeklyPay(p1);
		Paychecks pe1 = e2.getWeeklyPay(p2);
		
		assertEquals("Jack",pe1.getName());
		assertEquals(15.0,pe2.getPayRate());
		assertEquals(0,e1.getHoursWorked());
		assertEquals(0,e2.getHoursWorked());
	}
	
	// Pay raise tests
	@Test //TODO7
	public void testGetWeeklyPay() {
		e1.payRaise(1.1);
		e1.payRaise(1.2);
		
		assertEquals(33,e1.getPayRate());
		assertEquals(18,e2.getPayRate());
	}
*/	
	// Total employees number test
	@Test //TODO7
	public void testGetWeeklyPay() {
		assertEquals(3, Employee.getNumEmployees());
	}
}
