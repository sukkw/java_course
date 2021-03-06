package com.sirma.itt.javacourse.gui.calc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Calculator controller. Communicate with model and view.
 *
 * @version 1.1 14 June 2013
 * @author Stella Djulgerova
 */
public class CalculatorController {

	// class private members
	private Calculator model;
	private CalculatorView view;

	/**
	 * Constructor. Initialize variables.
	 * @param model - calculator model
	 * @param view - calculator view
	 */
	public CalculatorController(Calculator model, CalculatorView view) {
		this.model = model;
		this.view = view;

		view.addCalculationListener(new CalculationListener());
	}

	// Inner class. Create listener
	class CalculationListener extends MouseAdapter {

		/**
		 * Take action when mouse is clicked
		 */
		public void mouseClicked(MouseEvent event) {
			String clickedButton = event.getComponent().getName();
			int key = clickedButton.charAt(0);
			String result;

			// digits 0-9
			if(key > 47 && key < 58) {
				result = model.generateNumber(clickedButton); 
			    view.display(result);
			}
			// operators -, +, *, /
			if(key > 41 && key < 48) {
				model.setOperator(clickedButton);
			}
			// operator =
			if(key == 61) {
				result = model.calculate();
				view.display(result);
			}
			// char C (used to represent clear operation)
			if(key == 67) {
				model.clear();
				view.display("0");
			}
			// char B (used to represent Backspace operation)
			if(key == 66) {
				result = model.clearLastDigit(); 
				view.display(result);
			}
			// Char D (used to represent .)
			if(key == 68) {
				result = model.setDot(); 
				view.display(result);
			}
			// Char S (used to represent +/-)
			if(key == 83) {
				result = model.setSign();
				view.display(result);
			}
		}
	}
}