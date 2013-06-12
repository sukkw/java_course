package com.sirma.itt.javacourse.threads.synchstack;

import com.sirma.itt.javacourse.exceptions.ElementsList;
import com.sirma.itt.javacourse.exceptions.ListException;

/**
 * SynchronizedStack class. Creates stack. Add and remove elements to stack.
 * Detect if stack is empty or full.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedStack {

	private ElementsList stack;

	/**
	 * Constructor. Initialize variables
	 * @param stack - base stack
	 */
	public SynchronizedStack(ElementsList stack) {
		this.stack = stack;
	}

	/**
	 * Starts thread trying to add element to stack
	 * @param obj
	 */
	public void addThread(Object obj) {
		AddThread addThread = new AddThread(this, obj);
		addThread.start();
	}

	/**
	 * Starts thread trying to remove element from stack
	 */
	public void removeThread() {
		RemoveThread removeThread = new RemoveThread(this);
		removeThread.start();
	}

	/**
	 * Insert elements on the top of the stack.
	 * 
	 * @param obj - data to be inserted.
	 */
	public void add(Object obj) {

		// if stack is full thread have to wait
		synchronized (this) {
			while (stack.isFull()) {
				try {
					System.out.println("Stack is Full " + Thread.currentThread().getName() + " is waiting!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				stack.add(obj);
			} catch (ListException e) {
				e.printStackTrace();
			}
			notify();
		}
		System.out.println(Thread.currentThread().getName() + " added : " + obj);
	}

	/**
	 * Remove element from the top of the stack.
	 * 
	 * @return removed element
	 */
	public Object remove() {

		Object removed;
		// if stack is empty thread have to wait
		synchronized (this) {
			while (stack.isEmpty()) {
				try {
					System.out.println("Stack is Empty " + Thread.currentThread().getName() + " is waiting!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			removed = stack.remove();
			notify();
		}

		System.out.println(Thread.currentThread().getName() + " removed : " + removed);
		return removed;
	}

	/**
	 * print all elements in stack.
	 */
	public void print() {
		stack.printAllElements();
	}
}