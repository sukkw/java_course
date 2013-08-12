package com.sirma.itt.javacourse.decorators;

/**
 * Decorators base abstract class.
 * 
 * @version 1.1 01 August 2013
 * @author Stella Djulgerova
 */
public abstract class MsgDecorator implements ICustomMsgDecorator {
	// wrapped component
	ICustomMsgDecorator textArea;
}
