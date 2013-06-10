package com.sirma.itt.javacourse.threads.hash;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
* TimeoutHashtable run class. 
*
* @version 1.1 09 Jun 2013
* @author Stella Djulgerova
*/
public class TimeoutHashtableRun {

	/**
	 * Class main method. Allow user to chose between different options.
	 * @param args
	 */
	public static void main(String[] args) {
		
		TimeoutHashtable timeoutTable = new TimeoutHashtable();
		boolean checker = true;
		String key;
		String value;
		
		do {
			System.out.println(" P(ut) / G(et) / S(how) / R(emove) / E(xit)");
			String choice = ConsoleReader.readString();
			
			switch (choice) {
			case "P":
				System.out.println("Enter key: ");
				key = ConsoleReader.readString();
				System.out.println("Enter value: ");
				value = ConsoleReader.readString();
				timeoutTable.put(key, value);
				break;
			case "G":
				System.out.println("Enter key: ");
				key = ConsoleReader.readString();
				System.out.println(timeoutTable.get(key));
				break;
			case "S":
				timeoutTable.showElements();
				break;
			case "R":
				System.out.println("Enter key: ");
				key = ConsoleReader.readString();
				timeoutTable.remove(key);
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
