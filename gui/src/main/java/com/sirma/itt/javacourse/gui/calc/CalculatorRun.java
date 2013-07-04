package com.sirma.itt.javacourse.gui.calc;

/**
 * Calculator run class. Creates model, view and controller and starts application.
 *
 * @version 1.1 14 June 2013
 * @author Stella Djulgerova
 */
public class CalculatorRun {

	/**
	 * Class main method.
	 * @param args
	 */
    public static void main(String[] args) {
        
    	Calculator model = new Calculator();
    	CalculatorView view = new CalculatorView();
    	new CalculatorController(model, view);
        
        view.setVisible(true);
    }
}