package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExceptionsMessageManager {

	private Map<String, String> exceptions = new HashMap<String, String>();
	private String message = "";
	private final static String separator = "|";

	/**
	 * Constructor.
	 * @param exceptions - map containing all possible exceptions
	 */
	public ExceptionsMessageManager(Map<String, String> exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * Add exception to the message string. Map is search by value
	 * @param mess - searched value
	 */
	public void addExceptionMessage(String mess) {
		String stringToAdd = "";

		for(String value : exceptions.values()) {
			if (value.equals(mess)) {
				stringToAdd =  value;
				break;
			}
		}
		
		if(!notInString(stringToAdd)) return;
		
		if (!stringToAdd.equals("")) {
			message +=  stringToAdd + separator;
		} else {
			System.out.println("There's no such exception in map");
		}
	}

	/**
	 * Add exception to the message string. Map is search by key.
	 * @param messageCode - searched code 
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		String stringToAdd = "";
		
		for(String value : exceptions.keySet()) {
			if (value.equals(messageCode)) {
				stringToAdd = exceptions.get(value);
				break;
			}
		}
		
		if(!notInString(stringToAdd)) return;
		
		if (!stringToAdd.equals("")) {
			message +=  stringToAdd + separator;
		} else {
			System.out.println("There's no such exception in map");
		}
	}

	/**
	 * Return the value of message combination
	 * 
	 * @return message combination
	 */
	public String getMessage() {
		return this.message.substring(0, message.length()-1);
	}

	/**
	 * Split string and return all values as collection of strings.
	 * @param messagesCombination - message to be split
	 * @return - collection of strings
	 */
	public static Collection<String> getMessages(String messagesCombination) {
		Collection<String> elements = new ArrayList<String>();
		String[] separatedMessages = messagesCombination.split("\\" + separator);

		for (int i = 0; i < separatedMessages.length; i++) {
			elements.add(separatedMessages[i]);
			System.out.println(separatedMessages[i]);
		}
		
		return elements;
	}
	
	public boolean notInString(String mess) {
		
		for(String value : getMessages(message)) {
			if (value.equals(mess)) {
				return false;
			}
		}
		return true;
	}
}
