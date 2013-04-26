package com.sirma.itt.javacourse.reflection;

/**
 * Client manipulator run class.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClientManipulatorRun {
	
	public static void  main(String[] arg) {
		
		Client client = new Client();
		ClientManipulator manipulator = new ClientManipulator();
		
		manipulator.getMethodsInfo(client);
		manipulator.getFieldsInfo(client);
		
	}
}
