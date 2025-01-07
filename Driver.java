package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		MySinglyLinkedList<String> processQueueA = new MySinglyLinkedList<String>();
		File file = new File("Test Cases - Project1.txt");
		Scanner input = new Scanner(file);
		PtA processorA = new PtA();
		
		// Pt A		
		// Read input file and populate processQueueA
		while (input.hasNext()) {
			String line = input.next();
			processQueueA.addLast(line);
		}
		input.close();
		
		String strA = processQueueA.toString();
		String[] splitA = strA.split(";");
		splitA = strA.split(", ");
		
		// Process each line in splitA
		for (int i = 0; i < splitA.length; i++) {
			// System.out.println("Line number" + (i+1) + ": " + splitA[i]);
			
			String strProcess = splitA[i].toString();
			String[] process = strProcess.split(";");
			
			// Test and print the total number of cycles for the current line
			System.out.println("Total number of cycles in a line: " + processorA.testA(process));
			System.out.println();
		}
		
		// Pt B
		Random random = new Random();
		PtB processorB = new PtB();
		MySinglyLinkedList<String> processQueueB = new MySinglyLinkedList<String>();
		
		// Generate a random list of 20 processes
		for (int i = 1; i < 21; i++) {
			ArrayList<String> randomLetters = new ArrayList<>();
			int numLetters = random.nextInt(1, 4);
			
			// Generate random letters for each process
			for (int j = 0; j < numLetters; j++) {
				int indexLetter = random.nextInt(1, 4);
				
				if (indexLetter == 1)
					randomLetters.add("A");
				else if (indexLetter == 2)
					randomLetters.add("B");
				else if (indexLetter == 3)
					randomLetters.add("C");
			}
			
			// Ensure there are no duplicate letters in a process
			if (numLetters == 2) {
				while (randomLetters.get(0).equals(randomLetters.get(1))) {
					int indexLetter = random.nextInt(1, 4);
					
					if (indexLetter == 1)
						randomLetters.set(0, "A");
					else if (indexLetter == 2)
						randomLetters.set(0, "B");
					else if (indexLetter == 3)
						randomLetters.set(0, "C");
				}
			} else if (numLetters == 3) {
				while (randomLetters.get(0).equals(randomLetters.get(1)) ||
						randomLetters.get(0).equals(randomLetters.get(2)) ||
						randomLetters.get(1).equals(randomLetters.get(2))) {
					
					int indexLetter = random.nextInt(1, 4);
					
					if (randomLetters.get(0).equals(randomLetters.get(1))) {
						if (indexLetter == 1)
							randomLetters.set(0, "A");
						else if (indexLetter == 2)
							randomLetters.set(0, "B");
						else if (indexLetter == 3)
							randomLetters.set(0, "C");
					} else if (randomLetters.get(0).equals(randomLetters.get(2))) {
						if (indexLetter == 1)
							randomLetters.set(2, "A");
						else if (indexLetter == 2)
							randomLetters.set(2, "B");
						else if (indexLetter == 3)
							randomLetters.set(2, "C");
					} else if (randomLetters.get(1).equals(randomLetters.get(2))) {
						if (indexLetter == 1)
							randomLetters.set(1, "A");
						else if (indexLetter == 2)
							randomLetters.set(1, "B");
						else if (indexLetter == 3)
							randomLetters.set(1, "C");
					}
				}
			}
			
			String[] letters = new String[randomLetters.size()];
			String temp;
			
			// Convert randomLetters to an array
			for (int k = 0; k < randomLetters.size(); k++) {
				letters[k] = randomLetters.get(k);
			}
			
			// Create a process string and add it to processQueueB
			if (randomLetters.size() == 1)
				temp = "P" + i + "(" + letters[0] + ");";
			else if (randomLetters.size() == 2)
				temp = "P" + i + "(" + letters[0] + "," + letters[1] + ");";
			else
				temp = "P" + i + "(" + letters[0] + "," + letters[1] + "," + letters[2] + ");";
			
			processQueueB.addLast(temp);
		}
		
		System.out.println("Random List " + processQueueB);
		
		// Test and print the total cycles for processQueueB
		System.out.println("Total Cycles " + processorB.testB(processQueueB));
		
		System.out.println();
	}
}












