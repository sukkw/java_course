package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure diamond
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Diamond extends Square {

	// class private members
	private int angleB;
	private double hight;

	/**
	 * Draw diamond
	 */
	public void draw() {
		System.out.println("Diamond...");

	}

	/**
	 * Calculate surface of square
	 * 
	 * @return
	 */
	public double surface() {
		return this.getSideA() * hight;
	}

	/**
	 * Get angle b
	 * 
	 * @return
	 */
	public int getAngleB() {
		return angleB;
	}

	/**
	 * Set angle b
	 * 
	 * @param angle
	 */
	public void setAngleB(int angleB) {
		this.angleB = angleB;
	}

	/**
	 * get height to the side
	 * 
	 * @return
	 */
	public double getHight() {
		return hight;
	}

	/**
	 * Set height to the side
	 * 
	 * @param h
	 */
	public void setHight(double hight) {
		this.hight = hight;
	}

}
