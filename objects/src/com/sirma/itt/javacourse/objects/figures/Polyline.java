package com.sirma.itt.javacourse.objects.figures;

import java.util.ArrayList;

/**
 * Draw geometric figure polyline.
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public class Polyline extends Figure {

	// class private members
	private final int LINE = 0;
	private final int ARC = 1;

	private ArrayList<Point> points;
	private ArrayList<Integer> lineType;

	/**
	 * draw polyline.
	 */
	public void draw() {
		System.out.println("Point...");

	}

	/**
	 * Get all points.
	 * 
	 * @return all angles in polyline represented as points
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
	 * @return all lines between polyline angles
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
