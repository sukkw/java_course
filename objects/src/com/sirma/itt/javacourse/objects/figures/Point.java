package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure point
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Point extends Figure {

	// class private members
	private final int radius = 0;

	/**
	 * Draw point
	 */
	public void draw() {
		System.out.println("Point...");
	}

	/**
	 * get circle's radius
	 * 
	 * @return radius
	 */
	public float getRadius() {
		return radius;
	}
}
