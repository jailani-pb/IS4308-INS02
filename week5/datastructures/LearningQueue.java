package week5.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class LearningQueue {

	public static void main(String[] args) {
		Queue<String> nameList = new LinkedList<String>();
		nameList.offer("Abu");
		nameList.offer("Fatimah");
		nameList.offer("Bob");
		nameList.offer("Abdul");
		
		System.out.println(nameList);
		
		System.out.println(nameList.peek());
		System.out.println(nameList.peek());
		
		System.out.println(nameList.poll());
		System.out.println(nameList.peek());
		
		while(!nameList.isEmpty()) {
			System.out.println(nameList.poll());
		}
		
		System.out.println(nameList);
	}
	
}
