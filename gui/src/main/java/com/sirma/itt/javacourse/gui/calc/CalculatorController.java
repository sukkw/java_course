package com.sirma.itt.javacourse.gui.calc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Calculator controller. Communicate with model and view.
 *
 * @version 1.1 14 Jun 2013
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
	class CalculationListener implements MouseListener {

		/**
		 * Take action when mouse is clicked
		 */
		public void mouseClicked(MouseEvent event) {
			String clickedButton = event.getComponent().getName();
			String result;
			
			switch (clickedButton) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				result = model.generateNumber(clickedButton); 
			    view.display(result);
			    break; 
			case "+":
			case "-":
			case "*":
			case "/":
				model.setOperator(clickedButton);
			    break; 
			case "=":
				result = model.calculate();
				view.display(result);
			    break; 
			case "C":
				model.clear();
				view.display("0");
			    break; 
			case "Backspace":
				result = model.clearLastDigit(); 
				view.display(result);
			    break; 
			case ".":
				result = model.setDot(); 
				view.display(result);
			    break; 
			case "-/+":
				result = model.setSign();
				view.display(result);
			    break; 
			}
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}