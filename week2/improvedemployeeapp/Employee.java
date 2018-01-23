package week2.improvedemployeeapp;

import java.time.LocalDate;

public class Employee {

	final int MIN_AGE = 18;
	final int MAX_AGE = 60;
	
	private int id;
	String name;
	private int yearOfBirth;
	private static int numberEmployee = 0;
	
	public Employee(String name, int yearOfBirth) {
		this.name = name;
		editYearOfBirth(yearOfBirth);
		numberEmployee++;
		this.id = numberEmployee;
	}
	
	public void editYearOfBirth(int yearOfBirth) {
		// Local Variable
		LocalDate now = LocalDate.now();
		LocalDate minimumYearOfBirth = now.minusYears(MAX_AGE);
		LocalDate maximumYearOfBirth = now.minusYears(MIN_AGE);
		if(yearOfBirth >= minimumYearOfBirth.getYear() 
				&& yearOfBirth <= maximumYearOfBirth.getYear()) {
			this.yearOfBirth = yearOfBirth;
		} else {
			this.yearOfBirth = maximumYearOfBirth.getYear();
		}
	}
	
	public int getEmployeeAge() {
		LocalDate now = LocalDate.now();
		LocalDate age = now.minusYears(yearOfBirth);
		return age.getYear();
	}
	
	// Exercise
	// Implement method overloading to getEmployeeAge
	// The method should accept a specific year
	// and calculate the age of the employee for that
	// specific year
	// Return the age of the employee
	public int getEmployeeAge(int specificYear) {
		// Complex solution
//		LocalDate now = LocalDate.now();
//		LocalDate age = now.minusYears(yearOfBirth);
//		LocalDate difference = now.minusYears(specificYear);
//		return age.getYear()-difference.getYear();
		
		// Simple solution
		int age = specificYear - yearOfBirth;
		return age;
	}
	
	public static int getNumberEmployee() {
		return numberEmployee;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", yearOfBirth=" + yearOfBirth + "]";
	}
	
}
