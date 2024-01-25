package employeesAndPaychecks;

public class Driver {

	public static void main(String[] args) {
//		Employee e4 = new Employee("hi", 20.0);
//		
//		System.out.println(e4.getEmID());
//		
//		Employee e5 = new Employee("hello", 30.0);
//		
//		System.out.println(e5.getEmID());
		
		Employee e1 = new Employee("sharon", 30.5);
		System.out.println("11111--" + e1.getHoursWorked());
		

		
		Paychecks p = new Paychecks(e1);
		
		System.out.println("2222--" + p.getHoursWorked());
		
		e1.addHoursWorked(100);
		p.hoursWorked = e1.getHoursWorked();
		
		System.out.println("3333--" + e1.getHoursWorked());
		
		System.out.println("4444--" + p.getHoursWorked());
		
	}

}
