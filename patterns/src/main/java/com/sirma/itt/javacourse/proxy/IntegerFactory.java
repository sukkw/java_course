package com.sirma.itt.javacourse.proxy;

/**
 * Create instance of IntegerProxy.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class IntegerFactory {

	public IntegerFactory() {}
	
	/**
	 * Creates instances of the proxy.
	 * @return created instance.
	 */
	public static IntegerImpl createInstance() {	 
		return new IntegerProxy();
	}
}
