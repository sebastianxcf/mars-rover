package com.scastellanos.marsrover.domain;

public class MarsRover {

	private Coordinates coordinates;

	private Direction direction;

	private Grid grid;

	
	public MarsRover(Coordinates coordinates, Direction direction, Grid grid) {
		this.coordinates = coordinates;
		this.direction = direction;
		this.grid = grid;
	}

	public void turnLeft() {
		this.direction = this.direction.turnLeft();
		System.out.println("We are looking at " + direction.name());
	};

	public void turnRight() {
		this.direction = this.direction.turnRight();
		System.out.println("We are looking at " + direction.name());
	};

	public void moveFoward() {
		this.coordinates.moveForward(direction.toString());   
		System.out.println("Mooving Foward,we are in position > " + this.coordinates.toString()); 
	};

	public void moveBack() {
		this.coordinates.moveBack(direction.toString()); 
	    System.out.println("Mooving back, we are in position > " + this.coordinates.toString()); 
	};

	public boolean hasObstacles(Coordinates coordinates) {
		if(grid.hasObstacle(coordinates))
            return true;
		return false;
	}
	/**
	 * @return the coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}


}
