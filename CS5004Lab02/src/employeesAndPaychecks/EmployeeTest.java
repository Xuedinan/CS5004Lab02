package employeesAndPaychecks;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

/*
Name: Xuedinan Gao
Semester: Spring 2024
Assignment: CS5004Lab02

*/

public class EmployeeTest {

	Employee e1;
	Employee e2;
	Employee e3;
	
	@Before
	public void setup()throws Exception{
		try {
			e1 = new Employee("Jack", 30.0);
			e2 = new Employee("Lucy", 15.0);
			e3 = new Employee("Tom", 20.0);
			
			Employee test = new Employee("Negative pay rate", -1);
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	//Getters and setters tests
	@Test
	public void gettersAndSetters() throws Exception
	{
		e1.setPayRate(40.0);
		e2.setName("Bobby");
		
		assertEquals("Bobby",e2.getName());
		assertEquals(40.0,e1.getPayRate(), 0.001);
	}
	
	
	@Test
	public void testSetPayRate() throws Exception
	{	
		e1.setPayRate(40);
		e2.setPayRate(-1);
	
		assertEquals(40, e1.getPayRate(), 0.001);
		assertEquals(15, e2.getPayRate(), 0.001);
	}
	
	
	@Test
	public void testSetHoursWorked() throws Exception
	{	
		e1.setHoursWorked(300);
		e2.setHoursWorked(-1);
		
		assertEquals(300, e1.getHoursWorked(), 0.001);
		assertEquals(0, e2.getHoursWorked(), 0.001);
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
	public void testAddHoursWorked() throws Exception {
		
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		e3.addHoursWorked(30);
		e3.addHoursWorked(-1);
		
		assertEquals(100,e1.getHoursWorked(), 0.001);
		assertEquals(50,e2.getHoursWorked(), 0.001);
		assertEquals(30,e3.getHoursWorked(), 0.001);
	}
	

	// Reset hours worked test
	@Test
	public void testRestHoursWorked() throws Exception {
		e1.addHoursWorked(100);
		e2.addHoursWorked(50);
		
		assertEquals(100,e1.getHoursWorked(), 0.001);
		assertEquals(50,e2.getHoursWorked(), 0.001);
		
		e1.resetHoursWorked();
		e2.resetHoursWorked();
		
		assertEquals(0,e1.getHoursWorked(), 0.001);
		assertEquals(0,e2.getHoursWorked(), 0.001);
	}
	
	// Get weekly pay tests
	@Test
	public void testGetWeeklyPay() throws Exception {
		e1.addHoursWorked(40);
		Paychecks pe1 = e1.getWeeklyPay();
		
		e2.addHoursWorked(100);
		Paychecks pe2 = e2.getWeeklyPay();
		
		assertEquals(1200, pe1.getTotalPay(), 0.001);
		assertEquals(40, pe1.getHoursWorked(), 0.001);
		
		assertEquals(1950, pe2.getTotalPay(), 0.001);
		assertEquals(100, pe2.getHoursWorked(), 0.001);
	}
	

	@Test
	public void testGetWeeklyPayParameter() throws Exception {
		
		Paychecks p1 = new Paychecks();
		Paychecks p2 = new Paychecks();
		Paychecks p3 = new Paychecks();		
		
		Paychecks pye1 = e1.getWeeklyPay(p1);
		Paychecks pye2 = e2.getWeeklyPay(p2);
		
		assertEquals("Jack", pye1.getName());
		assertEquals(15.0, pye2.getPayRate(), 0.001);
		assertEquals(0, e1.getHoursWorked(), 0.001);
		assertEquals(0, e2.getHoursWorked(), 0.001);
		
		// test reset worked hours after assigned it to blank paycheck
		e3.addHoursWorked(100);
		assertEquals(100,e3.getHoursWorked(), 0.001);
		
		Paychecks pye3 = e3.getWeeklyPay(p3);
		assertEquals(0, e3.getHoursWorked(), 0.001);
	}

	// Pay raise tests
	@Test
	public void testPayRaise() {
		e1.payRaise(1.1);
		e2.payRaise(1.2);
		e2.payRaise(-1);
		
		assertEquals(33, e1.getPayRate(), 0.001);
		assertEquals(18, e2.getPayRate(), 0.001);
	}
	
	// Pay decrease tests
	@Test
	public void testPayDerease() {
		e1.payDecrease(0.1);
		e2.payDecrease(0.2);
		e2.payDecrease(-1);
		
		assertEquals(27, e1.getPayRate(), 0.001);
		assertEquals(12, e2.getPayRate(), 0.001);
	}
}
