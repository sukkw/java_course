package com.sirma.itt.javacourse.threads.warehouse;

/**
* Warehouse run class.
*
* @version 1.1 10 Jun 2013
* @author Stella Djulgerova
*/
public class WarehouseRun {

	/**
	 * Class main method. Initialize and starts producers and consumers
	 * threads.
	 * @param args
	 */
	public static void main(String[] args) {

		Warehouse warehouse = new Warehouse();
		Producer producerOne = new Producer(4, "Producer1", warehouse);
		Producer producerTwo = new Producer(5, "Producer2", warehouse);
		Producer producerThree = new Producer(3, "Producer3", warehouse);

		Consumer consumerOne = new Consumer(5, "Consumer1", warehouse);
		Consumer consumerTwo = new Consumer(3, "Consumer2", warehouse);
		Consumer consumerThree = new Consumer(4, "Consumer3", warehouse);

	}
}
