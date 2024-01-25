package employeesAndPaychecks;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaychecksTest {
	
	Employee e5 = new Employee("Sharon", 30.5);
	
	Paychecks p1 = new Paychecks();
	Paychecks p2 = new Paychecks("Lucy",25.5, 2, 40.0);
	Paychecks p3 = new Paychecks(e5);
	
	
	//Getters and setters were requested. Let's check
	@Test
	public void gettersAndSetters()
	{
		assertEquals(0, p1.getHoursWorked(), 0.001);
		assertEquals("Lucy", p2.getName());
		assertEquals("Sharon", p3.getName());
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
	public void testTotalPay()
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
	public void testOverTime()
	{
		e5.addHoursWorked(100);
		p3.hoursWorked = e5.getHoursWorked();
		
		assertEquals(60, p3.getOverTime(), 0.001);
		assertEquals(0, p2.getOverTime(), 0.001);
	}	

	

//	//toString test
//	@Test //TODO4
//	public void testToString()
//	{
//		assertEquals("", p1.toString());
//
//	}
}

