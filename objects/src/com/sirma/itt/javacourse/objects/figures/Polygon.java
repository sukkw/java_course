package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure polygon.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Polygon extends Parallelogram {

	// class private members
	private double sideC;
	private double sideD;
	private double angleC;
	private double angleD;

	/**
	 * Draw polygon.
	 */
	public void draw() {
		System.out.println("Polygon...");

	}

	/**
	 * Get side c.
	 * 
	 * @return side c length
	 */
	public double getSideC() {
		return sideC;
	}

	/**
	 * Set side c.
	 * 
	 * @param sideC - side c length
	 */
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	/**
	 * Get side d.
	 * 
	 * @return side d length
	 */
	public double getSideD() {
		return sideD;
	}

	/**
	 * Set side d.
	 * 
	 * @param sideD - side d length
	 */
	public void setSideD(double sideD) {
		this.sideD = sideD;
	}

	/**
	 * Get angle c.
	 * 
	 * @return angle c value
	 */
	public double getAngleC() {
		return angleC;
	}

	/**
	 * Set angle c.
	 * 
	 * @param angleC - angle c value
	 */
	public void setAngleC(double angleC) {
		this.angleC = angleC;
	}

	/**
	 * Get angle d.
	 * 
	 * @return angle d value
	 */
	public double getAngleD() {
		return angleD;
	}

	/**
	 * Set angle d.
	 * 
	 * @param angleD - angle d value
	 */
	public void setAngleD(double angleD) {
		this.angleD = angleD;
	}

	/**
	 * Calculate round of polygon.
	 * 
	 * @return round of polygon
	 */
	public double round() {
		return (this.getSideA() + this.getSideB() + sideC + sideD);
	}

	/**
	 * Calculate surface of polygon.
	 * 
	 * @return surface of polygon
	 */
	public double surface() {
		return 0;
	}

}
