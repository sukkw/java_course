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
		static int count = 0;
	}

	private TypeStack top;
	private int count = TypeStack.count;
	static int SIZE = 5;

	/**
	 * Check if the stack is empty.
	 * 
	 * @return true if it is empty
	 */
	private boolean isEmpty() {
		return top == null;
	}

	/**
	 * Check if stack is full.
	 * 
	 * @return true if stack is empty or not full
	 */
	public boolean notFull() {

		if (isEmpty()) {
			return true;
		} else if (count < SIZE) {
			return true;
		}

		return false;
	}

	/**
	 * Insert elements on the top of the stack.
	 * 
	 * @param obj - object to be inserted.
	 * @throws FullListException
	 */
	public void add(Object obj) throws FullListException {

		TypeStack newStack = new TypeStack();

		if (notFull()) {
			count++;
			newStack.data = obj;
			newStack.previous = top;
			top = newStack;
		} else {
			throw new FullListException(
					"You can't add more elements!");
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