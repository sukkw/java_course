package com.sirma.itt.javacourse.objects.figures;

import java.util.ArrayList;

/**
 * Draw geometric figure polyline
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Polyline extends Figure {

	private final int LINE = 0;
	private final int ARC = 1;

	ArrayList<Point> projectilePoints;
	ArrayList<Integer> lineType;

	/**
	 * draw polyline
	 */
	public void draw() {
		System.out.println("Point...");

	}

}
