package employeesAndPaychecks;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PaychecksTest {
	
	Employee e5;
	
	Paychecks p1;
	Paychecks p2;
	Paychecks p3;
	
	@Before //test constructor
	public void setup()throws Exception{
	
	try {
		e5 = new Employee("Sharon", 30.5);
		
		p1 = new Paychecks();
		p2 = new Paychecks("Lucy",25.5, 2, 40.0);
		p3 = new Paychecks(e5);
		
		}
	catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	//Getters and setters tests
	@Test
	public void gettersAndSetters()
	{
		assertEquals(0, p1.getHoursWorked(), 0.001);
		assertEquals("Lucy", p2.getName());
		assertEquals("Sharon", p3.getName());
	}
	
	@Test
	public void testSetPayrate()
	{	p1.setPayRate(30);
		p2.setPayRate(-1);
		
		assertEquals(30, p1.getPayRate(), 0.001);
		assertEquals(25.5, p2.getPayRate(), 0.001);
	}
	
	@Test
	public void testSetHoursWorked()
	{	p1.setHoursWorked(300);
		p2.setHoursWorked(-1);
		
		assertEquals(300, p1.getHoursWorked(), 0.001);
		assertEquals(40, p2.getHoursWorked(), 0.001);
	}
	
	@Test
	public void testSetOverTime() throws Exception
	{	p1.setOverTime(300);
		p2.setOverTime(-1);
		
		// overtime is 0, because worked hours is 0, added 300hours won't count
		assertEquals(0, p1.getOverTime(), 0.001);
		
		// add worked 40 hours
		p1.addHoursWorked(40);
		
		// add overtime 200 hours
		p1.setOverTime(200);
		assertEquals(200, p1.getOverTime(), 0.001);
		
		assertEquals(0, p2.getOverTime(), 0.001);
	}	

	
	// Add hours worked test
	@Test 
	public void testAddHoursWorked() throws Exception {
		
		p1.addHoursWorked(100);
		p2.addHoursWorked(50);
		p3.addHoursWorked(30);
		p3.addHoursWorked(-1);
		
		assertEquals(100,p1.getHoursWorked(), 0.001);
		assertEquals(90,p2.getHoursWorked(), 0.001);
		assertEquals(30,p3.getHoursWorked(), 0.001);
	}	
	
	
	//load check test
	@Test
	public void testLoadCheck() throws Exception
	{
		p1.loadCheck(e5);
		
		assertEquals("Sharon", p1.getName());
		assertEquals(30.5, p1.getPayRate(), 0.001);
		assertEquals(0, p1.getHoursWorked(), 0.001);
	}
	
	//Total pay test
	@Test
	public void testTotalPay() throws Exception
	{
		e5.addHoursWorked(100);
		p3.hoursWorked = e5.getHoursWorked();
		
		// 40*30.5 + 60*30.5*1.5
		assertEquals(3965, p3.getTotalPay(), 0.001);
		
		//25.5 * 40
		assertEquals(1020, p2.getTotalPay(), 0.001);
	}
	
	//Over time test
	@Test
	public void testOverTime() throws Exception
	{
		e5.addHoursWorked(100);
		p3.hoursWorked = e5.getHoursWorked();
		
		assertEquals(60, p3.getOverTime(), 0.001);
		assertEquals(0, p2.getOverTime(), 0.001);
	}	

}

