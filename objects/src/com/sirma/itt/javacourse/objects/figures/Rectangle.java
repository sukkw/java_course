package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure rectangle.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Rectangle extends Square {

	// class private members
	private double sideB;

	/**
	 * Draw rectangle.
	 */
	public void draw() {
		System.out.println("Rectangle...");
	}

	/**
	 * Calculate surface of rectangle.
	 * 
	 * @return surface of rectangle
	 */
	public double surfice() {
		return this.getSideA() * sideB;
	}

	/**
	 * Calculate round of rectangle.
	 * 
	 * @return round of rectangle
	 */
	public double round() {
		return (2 * this.getSideA()) + (2 * sideB);
	}

	/**
	 * Get side b.
	 * 
	 * @return side b length
	 */
	public double getSideB() {
		return sideB;
	}

	/**
	 * Set side b.
	 * 
	 * @param sideB - side b length
	 */
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}
}
