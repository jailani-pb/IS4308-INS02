package week5.datastructures;

import java.util.Stack;

public class LearningStack {

	public static void main(String[] args) {
		Stack<String> nameList = new Stack<String>();
		nameList.push("Abu");
		nameList.push("Fatimah");
		nameList.push("Bob");
		nameList.push("Abdul");
		
		System.out.println(nameList);
		
		System.out.println(nameList.peek());
		System.out.println(nameList.peek());
		
		System.out.println(nameList.pop());
		System.out.println(nameList.peek());
		
		while(!nameList.isEmpty()) {
			System.out.println(nameList.pop());
		}
		
		System.out.println(nameList);
	}
	
}
