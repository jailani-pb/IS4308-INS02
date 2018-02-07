package week5.datastructures;

import java.util.ArrayList;

public class LearningArrayList {

	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		// Adding data to ArrayList
		nameList.add("Jailani");
		nameList.add("Abdul");
		nameList.add("Rahman");
		nameList.add(1, "Haji");
		
		System.out.println(nameList);
		
		// Removing data from ArrayList
		nameList.remove(0);
		nameList.remove("Rahman");
		
		System.out.println(nameList);
		
		// Editing data from ArrayList
		nameList.set(1, "Azim");
		
		System.out.println(nameList);
		
		// Retrieving data from ArrayList
		System.out.println(nameList.get(0));
		System.out.println(nameList.get(1));
		
		// Retrieving ArrayList size
		System.out.println(nameList.size());
		nameList.add("Jailani");
		System.out.println(nameList.size());
	}
	
}







