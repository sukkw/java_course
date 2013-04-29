package com.sirma.itt.javacourse.annotation;

/**
 * Plain order run class.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
public class PlainOrderRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Plane[] instances = { new Bomber(), new Airliner(), new Fighter(),
				new TransportAircraft() };
		
		PlainOrder plainOrder = new PlainOrder();
		plainOrder.orderInstances(instances);
	}
}
