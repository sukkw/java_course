package com.sirma.itt.javacourse.objects.figures;


/**
 * Draw geometric figure circle
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Circle extends Ellipse {
	
	
	// class private members
	private float radius;
	
	/**
	 * Draw circle
	 */
	public void draw() {
		System.out.println("Circle...");
	}

	/**
	 * get circle's radius
	 * @return radius
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Set circles radius
	 * @param radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
}
