package com.scastellanos.marsrover.domain;

import java.util.Arrays;

import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.parser.Parser;
import com.scastellanos.marsrover.util.ErrorCodes;

public class MarsRover {

	private Coordinates coordinates;

	private Direction direction;

	private Grid grid;
	
	private Parser parser;
	
	
	public MarsRover(Coordinates coordinates, Direction direction, Grid grid,Parser parser) throws CreationException {
		
		validateInit(coordinates,direction,parser);
		this.coordinates = coordinates;
		this.direction = direction;
		this.grid = grid;
		this.parser = parser;
	}
	
	
	private boolean validateInit(Coordinates coordinates, Direction direction,Parser parser) throws CreationException {
		if(direction==null) 
			throw new CreationException("Invalid direction");
		if(parser==null)
			throw new CreationException("Invalid parser");

		validateCoordinates(coordinates);
		return true;
	}
	
	private void validateCoordinates(Coordinates coordinate) throws CreationException {
		if(this.coordinates.getCordinateX() >= 0 && this.getCoordinates().getCordinateY()  >= 0) {
			if(!isValidateBounds(coordinates)) {
				throw new CreationException("Invalid bounds");
			}
			if(hasObstacles(coordinates)) {
				throw new CreationException("There is an obstacle in initial rover position");
			}
		}
	}
	
	
	public void play(String commands) throws MoveException {
		 for(String c : Arrays.asList(commands.split("")) ){  
    		parser.getCommands().get(c).move(this);
        }
	}
	
	public void turnLeft() {
		this.direction = this.direction.turnLeft();
		System.out.println("We are looking at " + direction.name());
	};

	public void turnRight() {
		this.direction = this.direction.turnRight();
		System.out.println("We are looking at " + direction.name());
	};
	
	public void moveFoward() throws MoveException {
		Coordinates previews = new Coordinates(this.coordinates);
		
		this.coordinates.moveForward(direction.toString());   
		try {
			validateMove(this.coordinates);
		}catch (MoveException e) {
			//In case of an obstacle detection, should not move.
			this.coordinates=previews;
			throw e;
		}
		System.out.println("Mooving Foward,we are in position > " + this.coordinates.toString()); 
	};
	
	/**
	 * Given a coordinate determinate if the move is valid or not
	 * @param coordinate
	 * @throws MoveException
	 */
	private void validateMove(Coordinates coordinate) throws MoveException  {
		if(!isValidateBounds(coordinates)) {
			throw new MoveException(ErrorCodes.MR_MOVE_101.getValue(),ErrorCodes.MR_MOVE_101.getDescription());
			
		}
		if(hasObstacles(this.coordinates)) {
			throw new MoveException(ErrorCodes.MR_MOVE_102.getValue(),ErrorCodes.MR_MOVE_102.getDescription());
		}
		
	}

	public void moveBack() {
		this.coordinates.moveBack(direction.toString()); 
	    System.out.println("Mooving back, we are in position > " + this.coordinates.toString()); 
	};

	/**
	 * Given a coordinates return true only if the move is inside of the grid limits.
	 * @param coordenate
	 * @return
	 */
	private boolean isValidateBounds(Coordinates coordenate){
		if(coordenate!=null && this.grid!=null) {
			if(coordenate.getCordinateX() > grid.getTopRightCoordinates().getCordinateX()   ||
			   coordenate.getCordinateX() < grid.getBottomLeftCoordinates().getCordinateX() ||
			   coordenate.getCordinateY() > grid.getTopRightCoordinates().getCordinateY() ||
			   coordenate.getCordinateY() < grid.getBottomLeftCoordinates().getCordinateY()) {
				return false;
			}
		}
		return true;
		
	}
	
	
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
