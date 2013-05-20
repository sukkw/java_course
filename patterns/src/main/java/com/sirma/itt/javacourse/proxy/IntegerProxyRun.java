package com.sirma.itt.javacourse.proxy;

/**
 * IntegerProxy run class. 
 * Gets an instance of the IntegerProxy from the factory. 
 * Use proxy to get access to the real Integer class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class IntegerProxyRun {

	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {

		IntegerProxy proxy = (IntegerProxy) IntegerFactory.createInstance();

		// use proxy for different operations.
		proxy.add(12, 10);
		proxy.print();
		proxy.subtract(12, 10);
		proxy.print();
		proxy.multy(12, 10);
		proxy.print();
		
		try {
			proxy.divide(12, 10);
			proxy.print();
		} catch(ArithmeticException e) {
			System.out.println("Division by zero");
		}
	}

}
