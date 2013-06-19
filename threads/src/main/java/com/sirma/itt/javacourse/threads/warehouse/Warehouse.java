package com.sirma.itt.javacourse.threads.warehouse;

/**
 * Warehouse class. Add and remove stocks from warehouse.
 * 
 * @version 1.1 10 Jun 2013
 * @author Stella Djulgerova
 */
public class Warehouse {

	// class private members
	private final int MAX_ALLOWED_PRODUCTION = 30;
	private int productionCounter;

	/**
	 * Get specified quantity from warehouse. If warehouse is empty thread is
	 * waiting.
	 * 
	 * @param qty - quantity to be get from warehouse
	 */
	public void getStock(int qty) {
		while ((productionCounter - qty) < 0) {
			synchronized (this) {
				try {
					System.out.println("Warehouse is empty! "+ Thread.currentThread().getName() + " is waiting ");
					wait();
					notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		productionCounter = productionCounter - qty;
		System.out.println(Thread.currentThread().getName() + " took " + qty
				+ " stocks from warehouse. Current stock = " + productionCounter);
	}

	/**
	 * Add specified quantity in warehouse. If warehouse is full thread is
	 * waiting.
	 * 
	 * @param qty - quantity to be add to warehouse
	 */
	public void putStock(int qty) {
		while ((productionCounter + qty) > MAX_ALLOWED_PRODUCTION) {
			synchronized (this) {
				try {
					System.out.println("Warehouse is full! " + Thread.currentThread().getName() + " is waiting");
					wait();
					notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		productionCounter = productionCounter + qty;
		System.out.println(Thread.currentThread().getName() + " added " + qty
				+ " stocks in warehouse. Current stock = " + productionCounter);
	}
}