package com.scastellanos.marsrover.domain;

import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.util.ErrorCodes;

/**
 * Representation of Coordinates, x and y represent a point in the grid.. 
 * @author scastellanos
 *
 */
public class Coordinates {

	private static final String NORTH = "NORTH";
	private static final String EAST = "EAST";
	private static final String WEST = "WEST";
	private static final String SOUTH = "SOUTH";

	public Coordinates(int cordinateX, int cordinateY) {
		this.cordinateX = cordinateX;
		this.cordinateY = cordinateY;
	}
	
	public Coordinates(Coordinates anotherCoordinate) {
		this.cordinateX = anotherCoordinate.cordinateX;
		this.cordinateY = anotherCoordinate.cordinateY;
	}

	private Integer cordinateX;
	private Integer cordinateY;

	public Coordinates() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "cordinateX= " + cordinateX + ", cordinateY=" + cordinateY;
	}
	
	/**
	 * Given a direction move one step forward depending of the direction.
	 * @param direction
	 */
	public void moveForward(String direction) {

		switch (direction) {
		case NORTH:
			this.cordinateY++;
			break;
		case EAST:
			this.cordinateX++;
			break;
		case WEST:
			this.cordinateX--;
			break;
		case SOUTH:
			this.cordinateY--;
			break;
		default:
			throw new IllegalStateException("Wrong Direction");
		}
	};

	/**
	 * Given a direction move one step backward depending of the direction.
	 * @param direction
	 * @throws MoveException 
	 */
	public void moveBack(String direction) throws MoveException {
		switch (direction) {
		case NORTH:
			this.cordinateY--;
			break;
		case EAST:
			this.cordinateX--;
			break;
		case WEST:
			this.cordinateX++;
			break;
		case SOUTH:
			this.cordinateY++;
			break;
		default:
			throw new MoveException(ErrorCodes.MR_MOVE_204.getValue(),ErrorCodes.MR_MOVE_204.getDescription());
		}
	}

	/**
	 * @return the cordinateX
	 */
	public Integer getCordinateX() {
		return cordinateX;
	}

	/**
	 * @param cordinateX the cordinateX to set
	 */
	public void setCordinateX(Integer cordinateX) {
		this.cordinateX = cordinateX;
	}

	/**
	 * @return the cordinateY
	 */
	public Integer getCordinateY() {
		return cordinateY;
	}

	/**
	 * @param cordinateY the cordinateY to set
	 */
	public void setCordinateY(Integer cordinateY) {
		this.cordinateY = cordinateY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cordinateX == null) ? 0 : cordinateX.hashCode());
		result = prime * result + ((cordinateY == null) ? 0 : cordinateY.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Coordinates c=  (Coordinates)obj;
		if(c.getCordinateX().equals(this.getCordinateX()) && c.getCordinateY().equals(this.getCordinateY()))
			return true;
		return false;
	}

}
