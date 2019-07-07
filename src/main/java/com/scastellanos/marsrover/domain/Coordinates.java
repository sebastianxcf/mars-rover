package com.scastellanos.marsrover.domain;

public class Coordinates {

	public Coordinates(int cordinateX, int cordinateY) {
		this.cordinateX = cordinateX;
		this.cordinateY = cordinateY;
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
		return "Coordinates [cordinateX=" + cordinateX + ", cordinateY=" + cordinateY + "]";
	}

	/*
	 * Given a direction move one step forward
	 */
	public void moveForward(String direction) {

		switch (direction) {
		case "NORTH":
			this.cordinateY++;
			break;
		case "EAST":
			this.cordinateX++;
			break;
		case "WEST":
			this.cordinateX--;
			break;
		case "SOUTH":
			this.cordinateY--;
			break;
		default:
			throw new IllegalStateException("Wrong Direction");
		}
	};

	/*
	 * Given a direction move one step backward
	 */
	public void moveBack(String direction) {
		switch (direction) {
		case "NORTH":
			this.cordinateY--;
			break;
		case "EAST":
			this.cordinateX--;
			break;
		case "WEST":
			this.cordinateX++;
			break;
		case "SOUT":
			this.cordinateY++;
			break;
		default:
			throw new IllegalStateException("Wrong Direction");
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (cordinateX == null) {
			if (other.cordinateX != null)
				return false;
		} else if (!cordinateX.equals(other.cordinateX))
			return false;
		if (cordinateY == null) {
			if (other.cordinateY != null)
				return false;
		} else if (!cordinateY.equals(other.cordinateY))
			return false;
		return true;
	}

}
