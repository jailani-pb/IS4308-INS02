package week4.studentapplication;

public class RunProgram {

	public static void main(String[] args) {
		Module adpModule = 
				new Module("IS4308", "Advanced Programming", 3);
		Student student1 = new Student("Abu", 20);
		Student student2 = new Student("Bakar", 21);
		Student student3 = new Student("Curi", 22);
		Student student4 = new Student("Daging", 23);
		
		System.out.println("Module: " + adpModule.getCode() 
						+ adpModule.getName());
		printAddStudent(adpModule, student1);
		printAddStudent(adpModule, student2);
		printAddStudent(adpModule, student2);
		printAddStudent(adpModule, student4);
		printAddStudent(adpModule, student3);
		
		for(int i = 0; i < adpModule.getStudents().length; i++) {
			System.out.println(adpModule.getStudents()[i].getId());
			System.out.println(adpModule.getStudents()[i].getName());
		}
	}
	
	public static void printAddStudent(Module module, Student student) {
		System.out.println("Adding Student: " + student.getId() 
						+ " " + student.getName());
		System.out.println("Successful? " 
						+ module.addStudent(student));
	}
	
}
