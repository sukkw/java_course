package com.sirma.itt.javacourse.objects.figures;


/**
 * Draw geometric figure factory class
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class FigureFactory {

	/**
	 * Create geometric figure of different type
	 * @param newFigure
	 * @return
	 */
	public Figure makeFigure(String newFigure) {

		switch (newFigure) {

		case "0":
			return new Ellipse();
		case "1":
			return new Circle();
		case "2":
			return new Point();
		case "3":
			return new Arc();
		case "4":
			return new Polygon();
		case "5":
			return new Parallelogram();
		case "6":
			return new Diamond();
		case "7":
			return new Rectangle();
		case "8":
			return new Square();
		case "9":
			return new Polyline();

		}
		return null;

	}
}
