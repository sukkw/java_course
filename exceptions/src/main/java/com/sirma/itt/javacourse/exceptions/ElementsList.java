package com.sirma.itt.javacourse.exceptions;

import java.util.EmptyStackException;

/**
 * Create elements list. Add and remove elements. If list is empty or full.
 * throws exception
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsList {

	// inner class
	private static class TypeStack {

		public Object data;
		public TypeStack previous;
		public static int count = 0;
	}

	private TypeStack top;
	public static volatile int count = TypeStack.count;
	static int SIZE = 5;

	/**
	 * Check if the stack is empty.
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Check if stack is full.
	 * 
	 * @return true if stack is full
	 */
	public boolean isFull() {

		if (count == SIZE) {
			return true;
		}
		return false;
	}

	/**
	 * Insert elements on the top of the stack.
	 * 
	 * @param obj - object to be inserted.
	 * @throws ListException
	 */
	public void add(Object obj) throws ListException {

		TypeStack newStack = new TypeStack();
		
		if (isFull()) {
			throw new ListException("You can't add more elements!");
		} else {
			count++;
			newStack.data = obj;
			newStack.previous = top;
			top = newStack;
		}
	}

	/**
	 * Remove element from the top of the stack if not empty.
	 * 
	 * @return removed element
	 */
	public Object remove() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		TypeStack newstack = top;
		top = top.previous; 
		count--;
		return newstack.data;
	}

	/**
	 * printAllElements wrap method.
	 */
	public void printAllElements() {
		if (isEmpty()) {
			System.out.println("empty");
			return;
		}
		printAllElements(top);
	}

	/**
	 * Prints all element of the list.
	 * 
	 * @param obj -  top of the list
	 */
	private void printAllElements(TypeStack obj) {
		TypeStack curr = obj;
		if (curr != null) {
			System.out.println(curr.data);
			printAllElements(curr.previous);
		}
	}
}