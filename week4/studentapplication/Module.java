package week4.studentapplication;

public class Module {

	private String code;
	private String name;
	private Student[] students;
	private int currentNumberStudent = 0;
	
	public Module(String code, String name, int maxStudent) {
		this.code = code;
		this.name = name;
		students = new Student[maxStudent];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
		return students;
	}

	public boolean addStudent(Student student) {
		if(students.length <= currentNumberStudent) {
			return false;
		}
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				if(students[i].getId() == student.getId()) {
					return false;
				}
			}
		}
		students[currentNumberStudent] = student;
		currentNumberStudent++;
		return true;
	}

	public String getCode() {
		return code;
	}
	
}
