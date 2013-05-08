package com.sirma.itt.javacourse.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialize and deserialize given object.
 * 
 * @version 1.1 02 May 2013
 * @author Stella Djulgerova
 */
public class Serializer {

	/**
	 * Serialize object and save it in file
	 * 
	 * @param path - path to the file
	 * @param object - object to be serialized
	 */
	public void saveObject(String path, Object object) {

		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			System.out.println("File can not be created. Please try again");
		}
	}

	/**
	 * Deserialize object saved in file
	 * 
	 * @param path - path to the file
	 * @return - deserialized object
	 * @throws IOException
	 */
	public Object getObject(String path) {

		Object object = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			object = (Object) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			System.out.println("File can not be find. Please try again");
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found.");
			return null;
		}
		return object;
	}
}
