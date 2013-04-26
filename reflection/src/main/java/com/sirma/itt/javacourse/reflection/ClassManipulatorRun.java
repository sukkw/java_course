package com.sirma.itt.javacourse.reflection;

/**
 * Class manipulator run class.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClassManipulatorRun {
	
	public static void  main(String[] arg) {
		
		Client client = new Client();
		//String str = new String();
		
		ClassManipulator manipulator = new ClassManipulator();
		manipulator.getMethodsInfo(client);
		manipulator.getFieldsInfo(client);
		
	}
}
