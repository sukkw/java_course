package com.sirma.itt.javacourse.threads.synchstack;

import java.util.Hashtable;
import java.util.logging.Logger;

/**
 * SynchronizedStack class. Creates stack. 
 * Add and remove elements to stack. Detect if stack is empty or full.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedStack {

	// inner class
	private static class TypeStack {
		
		public Object data;
		public TypeStack previous;
		static int count = 0;
	}

	private TypeStack top;
	private int count = TypeStack.count;
	private static int SIZE = 5;
	private Logger log  = Logger.getLogger("SynchronizedStack");

	/**
	 * Check if the stack is empty.
	 * 
	 * @return true if stack is empty
	 */
	private boolean isEmpty() {
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
	 * Create new thread to add element in stack.
	 * 
	 * @param obj - data to be added
	 */
	public void createAddThread(Object obj) {
		
		if(obj == null) {
			log.warning("Invalid params");
			return;
		}
		AddThread addThread = new AddThread(this, obj);
	}

	/**
	 * Insert elements on the top of the stack.
	 * 
	 * @param obj - data to be inserted.
	 */
	public synchronized void add(Object obj) {

		TypeStack newStack = new TypeStack();

		// if stack is full thread have to wait
		while (isFull()) {
			try {
				System.out.println("Stack is Full " + 
						Thread.currentThread().getName()
						+ " is waiting!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		newStack.data = obj;
		newStack.previous = top;
		top = newStack;

		System.out.println(Thread.currentThread().getName() + " added : " + obj);

		notifyAll();
	}

	/**
	 * Create new thread to remove element from stack.
	 */
	public void createRemoveThread() {
		RemoveThread removeThread = new RemoveThread(this);
	}

	/**
	 * Remove element from the top of the stack.
	 * 
	 * @return removed element
	 */
	public synchronized Object remove() {

		// if stack is empty thread have to wait
		while (isEmpty()) {
			try {
				System.out.println("Stack is Full " + 
						Thread.currentThread().getName()+ 
						" is waiting!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		TypeStack newstack = top;
		top = top.previous;
		System.out.println(Thread.currentThread().getName()+ " removed : "+newstack.data);
		count--;
		notifyAll();

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
	 * @param obj - top of the list
	 */
	private void printAllElements(TypeStack obj) {
		TypeStack curr = obj;
		if (curr != null) {
			System.out.println(curr.data);
			printAllElements(curr.previous);
		}
	}
}