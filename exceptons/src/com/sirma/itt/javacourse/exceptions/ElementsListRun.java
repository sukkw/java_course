package com.sirma.itt.javacourse.exceptions;

public class ElementsListRun {

	
	public static void main(String[] args) {
		
		Object[] elements = new Object[5];
		ElementsList elList = new ElementsList(elements);

		elList.read();
	}
}
