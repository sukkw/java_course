package com.sirma.itt.javacourse.objects.figures;

import java.util.ArrayList;

/**
 * Draw geometric figure polyline.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Polyline extends Figure {

	private final int LINE = 0;
	private final int ARC = 1;

	ArrayList<Point> points;
	ArrayList<Integer> lineType;

	/**
	 * draw polyline.
	 */
	public void draw() {
		System.out.println("Point...");

	}

	/**
	 * Get all points.
	 * 
	 * @return
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	/**
	 * Set points.
	 * 
	 * @param points
	 */
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	/**
	 * Get all connection lines.
	 * 
	 * @return
	 */
	public ArrayList<Integer> getLineType() {
		return lineType;
	}

	/**
	 * Set connection type line.
	 * 
	 * @param lineType
	 */
	public void setLineType(ArrayList<Integer> lineType) {
		this.lineType = lineType;
	}
}
