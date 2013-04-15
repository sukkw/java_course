package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure rectangle
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Rectangle extends Square {

	// class private members
	private double b;

	/**
	 * Draw rectangle
	 */
	public void draw() {
		System.out.println("Rectangle...");
	}

	/**
	 * Calculate surface of rectangle
	 * 
	 * @return
	 */
	public double surfice() {
		return this.getA() * b;
	}

	/**
	 * Calculate round of rectangle
	 * 
	 * @return
	 */
	public double round() {
		return (2 * this.getA()) + (2 * b);
	}

	/**
	 * get side b
	 * 
	 * @return
	 */
	public double getB() {
		return b;
	}

	/**
	 * set side b
	 * 
	 * @param b
	 */
	public void setB(double b) {
		this.b = b;
	}
}
