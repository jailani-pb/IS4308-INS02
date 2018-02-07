package week5.datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LearningTreeSet {

	public static void main(String[] args) {
		TreeSet<String> countryList = new TreeSet<String>();
		countryList.add("Brunei");
		countryList.add("Singapore");
		countryList.add("Malaysia");
		countryList.add("Thailand");
		countryList.add("Cambodia");
		countryList.add("Brunei");
		
		System.out.println(countryList);
		
		countryList.remove("Malaysia");
		System.out.println(countryList);
		
		System.out.println(countryList.contains("Malaysia"));
		System.out.println(countryList.contains("Brunei"));
		System.out.println(countryList.contains("brunei"));
		
		for(String country : countryList) {
			System.out.println(country);
		}
		
		Iterator<String> iterator = countryList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
