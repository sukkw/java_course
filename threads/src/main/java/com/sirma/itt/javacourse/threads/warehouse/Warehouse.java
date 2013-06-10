package com.sirma.itt.javacourse.threads.warehouse;

/**
* Warehouse class.  Add and remove stocks from warehouse.
*
* @version 1.1 10 Jun 2013
* @author Stella Djulgerova
*/
public class Warehouse {

	// class private members
	private final int MAX_ALLOWED_PRODUCTION = 30;
	private static volatile int productionCounter;
	
	/**
	 * Get specified quantity from warehouse.
	 * If warehouse is empty thread is waiting.
	 * @param qty - quantity to be get from warehouse
	 */
    public synchronized void getStock (int qty){
        while ((productionCounter - qty) < 0){
            try {
                System.out.println ("Warehouse is empty! " + Thread.currentThread().getName() + " is waiting ");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
        productionCounter = productionCounter - qty;
        System.out.println (Thread.currentThread().getName() + " took " + qty + " stocks from warehouse. Current stock = " + productionCounter);

        notifyAll ();
    }

    /**
     * Add specified quantity in warehouse.
     * If warehouse is full thread is waiting.
     * @param qty - quantity to be add to warehouse
     */
    public synchronized void putStock (int qty){
        while ((productionCounter + qty) > MAX_ALLOWED_PRODUCTION){
            try {
                System.out.println ("Warehouse is full! " + Thread.currentThread().getName() + " is waiting");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
        productionCounter = productionCounter + qty;
        System.out.println (Thread.currentThread().getName() + " added " + qty + " stocks in warehouse. Current stock = " + productionCounter);
        notifyAll();
    }
}