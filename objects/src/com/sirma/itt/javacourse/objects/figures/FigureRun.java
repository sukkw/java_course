package com.sirma.itt.javacourse.objects.figures;

import java.util.Scanner;

/**
 * Draw geometric figures run class.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class FigureRun {

	private static Scanner userInput;

	/**
	 * Main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] arr) {

		FigureFactory figureFactory = new FigureFactory();
		Figure figure = null;

		userInput = new Scanner(System.in);
		String figureType = "";
		System.out.println("Enter value between 0 and 9");

		if (userInput.hasNextLine()) {
			figureType = userInput.nextLine();
			figure = figureFactory.makeFigure(figureType);
		}

		if (figure != null) {
			figure.draw();
		} else {
			System.out.print("Invalid number");
		}

	}
}
