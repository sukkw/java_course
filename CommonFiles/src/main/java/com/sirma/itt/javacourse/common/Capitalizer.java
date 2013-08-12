package com.sirma.itt.javacourse.common;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * This class is used to capitalize first letter of given text.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */ 
public class Capitalizer extends DocumentFilter {
	
	/**
	 * When text is typed or paste in text field first letter
	 * is capitalized.
	 */
	public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
			String text, AttributeSet attr) throws BadLocationException {

		// if user type text fist letter is replaced with capital letter
		if (offset == 0 && text.length() == 1) {
			fb.replace(offset, length, text.toUpperCase(), attr);
		}
		
		// if user paste text in middle of the field nothing is replaced
		if (offset > 0) {
			fb.replace(offset, length, text, attr);
		}
		
		// if user paste text in the beginning of field fist letter is replaced
		// with capital letter
		if (offset == 0 && text.length() > 1) {
			text = text.substring(0, 1).toUpperCase() + text.substring(1);
			fb.replace(offset, length, text, attr);
		}
		
		// clear console if empty string is entered
		if("".equals(text)) {
			fb.replace(offset, length, text, attr);
		}
	}
}