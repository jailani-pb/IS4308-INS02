package week5.datastructures;

import java.util.LinkedList;
import java.util.ListIterator;

public class LearningLinkedList {

	public static void main(String[] args) {
		LinkedList<String> nameList = new LinkedList<String>();
		// Add data to LinkedList
		nameList.add("Jailani");
		nameList.add("Rahman");
		nameList.addFirst("Mohammad");
		nameList.addLast("Haji");
		
		System.out.println(nameList);
		
		ListIterator<String> iterator = nameList.listIterator();
		
		// Retrieve data and move the iterator
		iterator.next();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		
		System.out.println(nameList);
		
		// Removing data from LinkedList using ListIterator
		iterator.remove();
		System.out.println(nameList);
		// Remember to move the cursor (iterator) first before
		// removing the second time
		iterator.next();
		iterator.remove();
		System.out.println(nameList);
		
		// Adding data to LinkedList using ListIterator
		iterator.next();
		iterator.add("Bin");
		System.out.println(nameList);
		
		// Editing data from LinkedList using ListIterator
		iterator.next();
		iterator.set("Abu");
		System.out.println(nameList);
	}
	
}




