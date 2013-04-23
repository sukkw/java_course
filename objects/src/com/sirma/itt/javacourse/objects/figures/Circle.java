package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure circle.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Circle extends Figure {

	// class private members
	private float radius;

	/**
	 * Draw circle.
	 */
	public void draw() {
		System.out.println("Circle...");
	}

	/**
	 * Get circle's radius.
	 * 
	 * @return radius
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Set circles radius.
	 * 
	 * @param radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	/**
	 * Calculate surface of circle.
	 * 
	 * @return surface of circle
	 */
	public double surfice() {
		return 3.14 * radius * radius;
	}

	/**
	 * Calculate round of circle.
	 * 
	 * @return round of circle
	 */
	public double round() {
		return 2 * 3.14 * radius;
	}

}
