package com.sirma.itt.javacourse.command;

/**
 * Invokes different command operations. (Add, subtract, etc..)
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class CalculatorInvoker {

	/**
	 * Constructor.
	 * @param command - command to be executed
	 */
	public CalculatorInvoker() {
	}

	/**
	 * Call command execute method.
	 */
	public void calculate(Command command) {
		command.execute();
	}
}
