package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure parallelogram.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Parallelogram extends Diamond {

	// class private members
	private double sideB;

	/**
	 * Draw parallelogram.
	 */
	public void draw() {
		System.out.println("Parallelogram...");

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
	 * 
	 * @param sideB side b length
	 */
	public void setB(double sideB) {
		this.sideB = sideB;
	}

	/**
	 * Calculate round of parallelogram.
	 * 
	 * @return round of parallelogram
	 */
	public double round() {
		return (2 * this.getSideA()) + (2 * sideB);
	}
}
