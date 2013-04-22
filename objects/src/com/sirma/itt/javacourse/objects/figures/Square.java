package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure square.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Square extends Figure {

	// class private members
	private double sideA;
	private int angleA = 90;

	/**
	 * Draw square.
	 */
	public void draw() {
		System.out.println("Square...");
	}

	/**
	 * Calculate surface of square.
	 * 
	 * @return
	 */
	public double surface() {
		return sideA * sideA;
	}

	/**
	 * Calculate round of square.
	 * 
	 * @return
	 */
	public double round() {
		return 4 * sideA;
	}

	/**
	 * Get side a.
	 * 
	 * @return
	 */
	public double getSideA() {
		return sideA;
	}

	/**
	 * Set side a.
	 * 
	 * @param a
	 */
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	/**
	 * Get angle (90).
	 * 
	 * @return
	 */
	public int getAngleA() {
		return angleA;
	}

	/**
	 * Set angle (90).
	 * 
	 * @param angleA
	 */
	public void setAngleA(int angleA) {
		this.angleA = angleA;
	}
}
