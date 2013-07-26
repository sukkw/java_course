package com.sirma.itt.javacourse.common;

public class Validator {

	public static String validate(String nickname) {
		
		if(nickname.length() > 15) {
			return "Nickname is too long";
		}
		
		if(nickname.contains("[") || nickname.contains("]")) {
			return "Symbols [ and ] are not allowed";
		}
		
		return null;
	}
}
