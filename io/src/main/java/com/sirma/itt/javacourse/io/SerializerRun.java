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
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		DataClass serializedObject = new DataClass("XX-Lg-675P", 156.90, 3452);
		serializedObject.setQty(12);
		serializedObject.setAvailable(true);

		Serializer serializer = new Serializer();
		serializer.saveObject("serialize.ser", serializedObject);
		DataClass deserializedObject = serializer.getObject("serialize.ser");

		System.out.println("Deserialized DataClass: ");
		System.out.println("Name: " + deserializedObject.getName());
		System.out.println("Number: " + deserializedObject.getNumber());
		System.out.println("Value: " + deserializedObject.getValue());
		System.out.println("Quantity: " + deserializedObject.getQty());
		System.out.println("Available: " + deserializedObject.isAvailable());
	}
}