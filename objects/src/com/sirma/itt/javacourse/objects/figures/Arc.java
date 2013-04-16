package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure arc.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Arc extends Circle {

	// class private members
	private int angle;

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
	public int getAngle() {
		return angle;
	}

	/**
	 * set angle between radius
	 *
	 * @param angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	public double length() {
		return (angle / 360) * 2 * 3.14 * this.getRadius();
	}

}
