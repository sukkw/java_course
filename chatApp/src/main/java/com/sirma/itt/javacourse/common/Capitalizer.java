package com.sirma.itt.javacourse.common;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Capitalizer extends DocumentFilter {
	
	public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
			String text, AttributeSet attr) throws BadLocationException {

		if (offset == 0 && text.length() == 1) {
			fb.replace(offset, length, text.toUpperCase(), attr);
		}
		if (offset > 0) {
			fb.replace(offset, length, text, attr);
		}
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