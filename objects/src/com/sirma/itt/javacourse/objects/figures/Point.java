package com.sirma.itt.javacourse.objects.figures;

/**
 * Draw geometric figure point.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Point extends Figure {

	// class private members
	private int xCoord;
	private int yCoord;

	/**
	 * Draw point.
	 */
	public void draw() {
		System.out.println("Point...");
	}

	/**
	 * Get point x coordinate.
	 * 
	 * @return x coordinate of point
	 */
	public int getxCoord() {
		return xCoord;
	}

	/**
	 * Set point x coordinate.
	 * 
	 * @param xCoord - x coordinate value
	 */
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	/**
	 * Get point y coordinate.
	 * 
	 * @return y coordinate of point
	 */
	public int getyCoord() {
		return yCoord;
	}

	/**
	 * Set point y coordinate.
	 * 
	 * @param yCoord - y coordinate value
	 */
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

}
