package com.sirma.itt.javacourse.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Search in HashMap for different type of exception. 
 * If exception is found make string called "message". 
 * String is concatenation of different exception.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class ExceptionsMessageManager {

	// class private members
	private Map<String, String> exceptions = new HashMap<String, String>();
	private String message = "";
	private final static String separator = "|";

	/**
	 * Constructor.
	 * 
	 * @param exceptions - map containing all possible exceptions
	 */
	public ExceptionsMessageManager(Map<String, String> exceptions) {
		
		if(exceptions == null) {
			System.out.println("Wrong messages map");
		}
		
		this.exceptions = exceptions;
	}

	/**
	 * Add exception to the message string. Map is searched by value.
	 * If not such value is found throws exception.
	 * 
	 * @param mess - searched value
	 * @throws InvalidValueException 
	 */
	public void addExceptionMessage(String mess) throws InvalidValueException {

		StringBuilder buildMsg = new StringBuilder();
		
		if (!notInString(mess)) {
			return;
		}

		if (exceptions.containsValue(mess)) {

			if(message != "") {
				buildMsg.append(message);
				buildMsg.append(separator);
				buildMsg.append(mess);
			} else {
				buildMsg.append(mess);
			}
			
			message = buildMsg.toString();
		} else {
			 throw new InvalidValueException("There's no such exception in the table!");
		}
	}

	/**
	 * Add exception to the message string. Map is search by key.
	 * If not such key is found throws exception.
	 * 
	 * @param messageCode - searched code
	 * @throws InvalidValueException 
	 */
	public void addExceptionMessageCode(String messageCode) throws InvalidValueException {
		String mess = "";
		StringBuilder buildMsg = new StringBuilder();
		
		if (exceptions.containsKey(messageCode)) {
			mess = exceptions.get(messageCode);
			
			if (!notInString(mess)) {
				return;
			}
			
			if(message != "") {
				buildMsg.append(message);
				buildMsg.append(separator);
				buildMsg.append(mess);
			} else {
				buildMsg.append(mess);
			}
			
			message = buildMsg.toString();
		} else { 
			throw new InvalidValueException("There's no such exception in the table!");
		}
	}

	/**
	 * Return the value of message combination
	 * 
	 * @return message combination
	 */
	public String getMessage() {
		if("".equals(message)) {
			return "No exceptions in message";
		} else {
			return message;
		}
	}

	/**
	 * Split string and return all values as collection of strings.
	 * 
	 * @param messagesCombination - message to be split
	 * @return - collection of strings
	 */
	public static Collection<String> getMessages(String messagesCombination) {
		
		String[] separatedMessages = messagesCombination.split("\\" + separator);
		Collection<String> elements = Arrays.asList(separatedMessages);
		
		return elements;
	}

	/**
	 * Check if the exception is already in combination string.
	 * @param mess - string to be checked
	 * @return true if exception is already added, false if not.
	 */
	public boolean notInString(String mess) {

		for (String value : getMessages(message)) {
			if (value.equals(mess)) {
				return false;
			}
		}
		return true;
	}
}