package com.sirma.itt.javacourse.intro;

/**
 * Weight center of array run class.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class ArrayCenterRun {

	/**
	 * Class main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] args) {
		int[] array = Helper.loadAray(5);
		Helper.printArray(array);
		ArrayCenter arr = new ArrayCenter();
		System.out.println(" Centura na tejesta na masiva e:  " + arr.center(array));
	}
}