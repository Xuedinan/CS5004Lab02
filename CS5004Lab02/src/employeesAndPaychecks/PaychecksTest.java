package employeesAndPaychecks;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaychecksTest {
	
	Paycheck p1;
	Paycheck p2;
	Paycheck p3;

	
	@Before
	public void setUp() {
		
		p1 = new Paycheck();
		p2 = new Paycheck("Lucy", 2, 15, 40);
		p3 = new Employee(e1);
		
	}
	
	//Getters and setters were requested. Let's check
	@Test //TODO1
	public void gettersAndSetters()
	{
		assertEquals(0, p1.getHourWorked());
		assertEquals("Lucy", p2.getName());
		assertEquals("Jack", p3.getName());
	}
	
	//load check test
	@Test //TODO2
	public void testLoadCheck()
	{
		p1.loadCheck(e3);
		
		assertEquals("Tom", p1.getName());
		assertEquals(20, p1.getPayRate());
		assertEquals(3, p1.getEmId());
	}
	
	//Total pay test
	@Test //TODO3
	public void testTotalPay()
	{
		e1.addHoursWorked(100)
		
		assertEquals(3000, p1.getTotalPay());

	}
	
	//toString test
	@Test //TODO4
	public void testToString()
	{
		assertEquals("", p1.toString());

	}
}

