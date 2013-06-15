package com.sirma.itt.javacourse.gui.calc;

/**
* Calculator run class. Creates model, view and controller and starts application.
*
* @version 1.1 14 Jun 2013
* @author Stella Djulgerova
*/
public class Calculator {

	/**
	 * Class main method.
	 * @param args
	 */
    public static void main(String[] args) {
        
    	CalculatorModel model = new CalculatorModel();
    	CalculatorView view = new CalculatorView();
    	new CalculatorController(model, view);
        
        view.setVisible(true);
    }
}