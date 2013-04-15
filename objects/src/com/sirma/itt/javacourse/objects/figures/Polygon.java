package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure polygon
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Polygon extends Parallelogram {

	// class private members
	private double c;
	private double d;
	private double angleC;
	private double angleD;

	/**
	 * Draw polygon
	 */
	public void draw() {
		System.out.println("Polygon...");

	}

	/**
	 * get side c
	 * 
	 * @return
	 */
	public double getC() {
		return c;
	}

	/**
	 * set side c
	 * 
	 * @param c
	 */
	public void setC(double c) {
		this.c = c;
	}

	/**
	 * get side d
	 * 
	 * @return
	 */
	public double getD() {
		return d;
	}

	/**
	 * Set side d
	 * 
	 * @param d
	 */
	public void setD(double d) {
		this.d = d;
	}

	/**
	 * get angle c
	 * 
	 * @return
	 */
	public double getAngleC() {
		return angleC;
	}

	/**
	 * set angle c
	 * 
	 * @param angleC
	 */
	public void setAngleC(double angleC) {
		this.angleC = angleC;
	}
	
	/**
	 * get angle d
	 * 
	 * @return
	 */
	public double getAngleD() {
		return angleD;
	}

	/**
	 * set angle d
	 * 
	 * @param angleD
	 */
	public void setAngleD(double angleD) {
		this.angleD = angleD;
	}
	
	/**
	 * Calculate round of polygon
	 * 
	 * @return
	 */
	public double round() {
		return (this.getA() + this.getB() + c + d);
	}
	
	/**
	 * Calculate surface of polygon
	 * 
	 * @return
	 */
	public double surface() {
		return 0;
	}

}
