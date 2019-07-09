package com.scastellanos.marsrover.domain;


/**
 * This class represent an obstacle in the grid. It has a coordinate that represent x and y position.
 * 
 * @author scastellanos
 *
 */
public class Obstacle {
	private Coordinates coordinate;

	/**
	 * @return the coordinate
	 */
	public Coordinates getCoordinate() {
		return coordinate;
	}

	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
}
