package employeesAndPaychecks;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PaychecksTest {
	
	Employee e5;
	
	Paychecks p1;
	Paychecks p2;
	Paychecks p3;
	
	@Before
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

