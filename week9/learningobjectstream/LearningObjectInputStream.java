package week9.learningobjectstream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LearningObjectInputStream {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream input = 
				new ObjectInputStream(
						new FileInputStream("object.dat"))) {
			try {
				Student s;
				while(true) {
					s = (Student) input.readObject();
					System.out.println(s);
				}
			} catch (EOFException e) {
				System.out.println("End of file.");
			}
		}
	}
	
}







