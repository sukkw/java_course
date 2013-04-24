package com.sirma.itt.javacourse.libs;

import com.sirma.itt.javacourse.intro.ArrayCenter;
import com.sirma.itt.javacourse.intro.ArrayReverse;
import com.sirma.itt.javacourse.intro.Arrays;
import com.sirma.itt.javacourse.intro.Helper;
import com.sirma.itt.javacourse.intro.QuickSort;

/**
 * Reusability of code example
 * 
 * @version 1.1 24 April 2013
 * @author Stella Djulgerova
 */
public class CodeReuse {

	/**
	 * class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// load array
		int[] array = Helper.loadAray();

		// find min element and sum of all elements in array
		Arrays arrs = new Arrays();
		Helper.printArray(array);
		System.out.println(" Sumata na chislata v masiva e: "
				+ arrs.sumArray(array));
		System.out.println(" Naj-malkiq element v masiva e: "
				+ arrs.getMinElement(array));

		// find array center
		ArrayCenter arr = new ArrayCenter();
		System.out.println(" Centura na tejesta na masiva e: "
				+ arr.center(array));

		// reverse arrays elements
		ArrayReverse arrRev = new ArrayReverse();
		Helper.printArray(array);
		arrRev.reverse(array);
		Helper.printArray(array);

		// sort array using quick sort method
		QuickSort sort = new QuickSort();
		Helper.printArray(array);
		sort.sort(array, 0, array.length - 1);
		Helper.printArray(array);
	}

}
