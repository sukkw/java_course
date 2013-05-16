package com.sirma.itt.javacourse.patterns;

/**
 * Singleton design pattern run class.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class SingletonRun {

	/**
	 * Class main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
/*		try {
			Singleton instance3 = (Singleton) instance1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}*/
	}
}
