package week2.employeeapplication;

public class RunProgram {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Jailani", 35);
		System.out.println(employee1);
		System.out.println(employee1.getNumberEmployees());
		Employee employee2 = new Employee("Rahman", 65);
		employee2.editAge(50);
		System.out.println(employee2);
		System.out.println(employee2.getNumberEmployees());
		System.out.println(employee1.getNumberEmployees());
		System.out.println(employee1);
	}
	
}
