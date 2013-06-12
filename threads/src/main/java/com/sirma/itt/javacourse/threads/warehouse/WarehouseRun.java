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
		
		// initialize and starts producers
		Producer producerOne = new Producer(4, warehouse);
		producerOne.setName("Producer1");
		producerOne.start();
		Producer producerTwo = new Producer(5, warehouse);
		producerTwo.setName("Producer2");
		producerTwo.start();
		Producer producerThree = new Producer(3, warehouse);
		producerThree.setName("Producer3");
		producerThree.start();

		// initialize and starts consumers
		Consumer consumerOne = new Consumer(5, warehouse);
		consumerOne.setName("Consumer1");
		consumerOne.start();
		Consumer consumerTwo = new Consumer(3, warehouse);
		consumerTwo.setName("Consumer2");
		consumerTwo.start();
		Consumer consumerThree = new Consumer(4, warehouse);
		consumerThree.setName("Consumer3");
		consumerThree.start();

	}
}
