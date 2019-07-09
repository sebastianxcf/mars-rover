package com.scastellanos.marsrover.domain;

import java.util.Arrays;

import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.parser.Parser;
import com.scastellanos.marsrover.util.ErrorCodes;


/**
 * Represents the mars rover universe.
 * It has aa group of initials coordinates
 * A initial direction
 * A grid in which will move around
 * @author scastellanos
 *
 */
public class MarsRover {

	private Coordinates coordinates;

	private Direction direction;

	private Grid grid;
	
	private Parser parser;
	
	
	public MarsRover(Coordinates coordinates, Direction direction, Grid grid,Parser parser) throws CreationException {
		
		this.grid = grid;

		validateInit(coordinates,direction,parser);
		this.parser = parser;
		this.coordinates = coordinates;
		this.direction = direction;
	}
	
	/**
	 * Validate that all the inputs are valid. Correct direction, and coordinates inside the grid.
	 * @param coordinates
	 * @param direction
	 * @param parser
	 * @return
	 * @throws CreationException
	 */
	private boolean validateInit(Coordinates coordinates, Direction direction,Parser parser) throws CreationException {
		if(direction==null) 
			throw new CreationException(ErrorCodes.MR_CREATE_101.getValue(), ErrorCodes.MR_CREATE_101.getDescription());
		if(parser==null)
			throw new CreationException(ErrorCodes.MR_CREATE_105.getValue(), ErrorCodes.MR_CREATE_105.getDescription());

		validateCoordinates(coordinates);
		return true;
	}
	
	/**
	 * Given a start point of coordinates, validate that this coordinate is inside the grid bounds and also that there isn't obstacles in the same position
	 * @param paramCoordinates
	 * @throws CreationException
	 */
	private void validateCoordinates(Coordinates paramCoordinates) throws CreationException {
		if(paramCoordinates.getCordinateX() >= 0 && paramCoordinates.getCordinateY()  >= 0) {
			if(!isValidateBounds(paramCoordinates)) {
				throw new CreationException(ErrorCodes.MR_CREATE_102.getValue(),ErrorCodes.MR_CREATE_102.getDescription());
			}
			if(hasObstacles(paramCoordinates)) {
				throw new CreationException(ErrorCodes.MR_CREATE_103.getValue(),ErrorCodes.MR_CREATE_103.getDescription());
			}
		}else
			throw new CreationException(ErrorCodes.MR_CREATE_104.getValue(),ErrorCodes.MR_CREATE_104.getDescription());
	}
	
	
	/**
	 * Given a list of characters in a String, this function parser all the commands and try to execute all of them one by one.
	 * In case of found one wrong-formed character will thrown a MoveException with the explicit error message and code.
	 * @param commands
	 * @return
	 * @throws MoveException
	 */
	public Coordinates play(String commands) throws MoveException {
		for(String stringCommand : Arrays.asList(commands.split("")) ){
			validateCommand(commands); 
			parser.getCommands().get(stringCommand).move(this);
		}
		return this.coordinates;
	}
	
	/**
	 * 
	 * Validate if the char list of commands exist and it is in the correct format
	 * @param commands
	 * @throws MoveException
	 */
	private void validateCommand(String commands)throws MoveException {
		for(String stringCommand : Arrays.asList(commands.split("")) ){
			if(!parser.getCommands().containsKey(stringCommand)) {
				throw new MoveException(ErrorCodes.MR_MOVE_203.getValue(), ErrorCodes.MR_MOVE_203.getDescription());
			}
		}
	}
	
	/**
	 * Just turn the rover 45 degrees to left
	 */
	public void turnLeft() {
		this.direction = this.direction.turnLeft();
	};

	/**
	 * Just turn the rover 45 degrees to right
	 */
	public void turnRight() {
		this.direction = this.direction.turnRight();
	};
	
	/**
	 * Move forward the rove in the corresponding direction.
	 * @throws MoveException
	 */
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
	};
	
	/**
	 * Move backward the rove in the corresponding direction.
	 * @throws MoveException
	 */
	public void moveBack() throws MoveException {
		Coordinates previews = new Coordinates(this.coordinates);
		
		this.coordinates.moveBack(direction.toString());   
		try {
			validateMove(this.coordinates);
		}catch (MoveException e) {
			//In case of an obstacle detection, should not move.
			this.coordinates=previews;
			throw e;
		}
	};
	
	
	
	/**
	 * Given a coordinate determinate if the move is valid or not
	 * @param coordinate
	 * @throws MoveException
	 */
	private void validateMove(Coordinates coordinate) throws MoveException  {
		if(!isValidateBounds(coordinates)) {
			throw new MoveException(ErrorCodes.MR_MOVE_201.getValue(),ErrorCodes.MR_MOVE_201.getDescription());
			
		}
		if(hasObstacles(this.coordinates)) {
			throw new MoveException(ErrorCodes.MR_MOVE_202.getValue(),ErrorCodes.MR_MOVE_202.getDescription() + " " + coordinate.toString());
		}
		
	}


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
	
	
	/**
	 * Return true if exist at least one obstacle in the given coordinates.
	 * @param coordinates
	 * @return
	 */
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
