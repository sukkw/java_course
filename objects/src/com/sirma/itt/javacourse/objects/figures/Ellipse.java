package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure ellipse
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Ellipse extends Circle {

	// class private members
	private float minorSemiAxis;

	/**
	 * Drow ellipse
	 */
	public void draw() {
		System.out.println("Elipse...");
	}

	/**
	 * get ellipse minor SemiAxis
	 * 
	 * @return
	 */
	public float getMinorSemiAxis() {
		return minorSemiAxis;
	}

	/**
	 * set ellipse minorSemiAxis
	 * 
	 * @param minorSemiAxis
	 */
	public void setMinorSemiAxis(float minorSemiAxis) {
		this.minorSemiAxis = minorSemiAxis;
	}
	
	/**
	 * Calculate surface of circle
	 * 
	 * @return
	 */
	public double surfice() {
		return 3.14 * this.getRadius() * minorSemiAxis;
	}
	
	/**
	 * Calculate round of circle
	 * 
	 * @return
	 */
	public double round() {
		return 0;
	}

}
