package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure arc.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Arc extends Circle {

	// class private members
	private int angleBetweenRadius;

	/**
	 * Drow an arc
	 */
	public void draw() {
		System.out.println("Arc...");
	}

	/**
	 * get angle between radius
	 *
	 * @return
	 */
	public int getAngleBetweenRadius() {
		return angleBetweenRadius;
	}

	/**
	 * set angle between radius
	 *
	 * @param angle
	 */
	public void setAngleBetweenRadius(int angleBetweenRadius) {
		this.angleBetweenRadius = angleBetweenRadius;
	}

	public double length() {
		return (angleBetweenRadius / 360) * 2 * 3.14 * this.getRadius();
	}

}
