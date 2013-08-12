package com.sirma.itt.javacourse.decorators;

import java.awt.Color;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Concrete client messages decorator.
 * 
 * @version 1.1 01 August 2013
 * @author Stella Djulgerova
 */
public class ClientMsgDecorator extends MsgDecorator {

	// class private members
	private SimpleAttributeSet attrSet;
	private ICustomMsgDecorator originalSet;

	/**
	 * Constructor. Initialize variables.
	 * 
	 * @param attrSet
	 */
	public ClientMsgDecorator(ICustomMsgDecorator attrSet) {
		originalSet = attrSet;
	}

	/**
	 * Get styled component.
	 */
	public SimpleAttributeSet getComponent() {

		// secure original
		attrSet = addStyle(originalSet.getComponent());
		return attrSet;
	}

	/**
	 * Add different style to message.
	 * 
	 * @param attrSet - original attribute set
	 * @return - attribute set with added new style
	 */
	private SimpleAttributeSet addStyle(SimpleAttributeSet area) {
		
		// all simple messages are black
		StyleConstants.setForeground(area, Color.BLACK);
		return area;
	}
}
