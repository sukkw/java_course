package com.sirma.itt.javacourse.common;

/**
 * This class validate nickname entered by user.
 * [ and ] are not allowed. max allowed length is 15 symbols.
 * 
 * @version 1.1 29 July 2013
 * @author Stella Djulgerova
 */
public class Validator {
	
	/**
	 * Validate client nick name.
	 * @param nickname - client nick name
	 * @return - error if exist
	 */
	public static String validate(String nickname) {
	
		// nick name can not be empty
		if("".equals(nickname)) {
			return "empty";
		}
		
		// nick name can not be more than 15 symbols long
		if(nickname.length() > 15) {
			return "nickname_too_long";
		}
		
		// [ and ] are not allowed
		if(nickname.contains("[") || nickname.contains("]")) {
			return "forbiden_symbols";
		}
		
		return null;
	}
}