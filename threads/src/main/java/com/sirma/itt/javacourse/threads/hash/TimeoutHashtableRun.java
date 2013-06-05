package com.sirma.itt.javacourse.threads.hash;

import com.sirma.itt.javacourse.io.ConsoleReader;

public class TimeoutHashtableRun {

	public static void main(String[] args) {
		
		TimeoutHashtable timeoutTable = new TimeoutHashtable();
		boolean checker = true;
		
		do {
			System.out.println("A(dd) / P(ut) / G(et) / S(how) / E(xit)");
			String choice = ConsoleReader.readString();
			
			switch (choice) {
			case "A":
				System.out.println("Enter text:");
				timeoutTable.add(ConsoleReader.readString());
				break;
			case "P":
				break;
			case "G":
				break;
			case "S":
				timeoutTable.showElements();
				break;
			case "E":
				checker = false;
				break;
			default: 
				System.out.println(" Invalid option ");
				break;
			}
		} while(checker);
	}
}
