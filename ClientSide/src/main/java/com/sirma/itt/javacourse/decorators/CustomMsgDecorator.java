package com.sirma.itt.javacourse.decorators;

import javax.swing.text.SimpleAttributeSet;

/**
 * Concrete inplementation of decorator interface.
 * 
 * @version 1.1 01 August 2013
 * @author Stella Djulgerova
 */
public class CustomMsgDecorator implements ICustomMsgDecorator {

	// class private members
	private SimpleAttributeSet attrSet;
	
	/**
	 * Constructor. Initialize variables.
	 * 
	 * @param attrSet
	 */
	public CustomMsgDecorator(SimpleAttributeSet attrSet) {
		this.attrSet = attrSet;
	}
	
	/**
	 * Get styled component.
	 */
	public SimpleAttributeSet getComponent() {
		return attrSet;
	}
}
