package com.sirma.itt.javacourse.io;

import java.io.IOException;

/**
 * DataClass run class.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class SerializerRun {

	/**
	 * Class main method
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		DataClass object = new DataClass("XX-Lg-675P", 156.90, 3452);
		object.setQty(12);
		object.setAvailable(true);
		
		Serializer serializer = new Serializer();
		serializer.saveObject("serialize.ser", object);
		serializer.getObject("serialize.ser");
	}
}
