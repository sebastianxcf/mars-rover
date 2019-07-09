package com.scastellanos.marsrover.dto;

import java.util.List;

import com.scastellanos.marsrover.domain.Direction;

/**
 * This class is the representation of all necessary attributes to initialize the mars-rover.
 * This object is only used by the controllers layer or the service in case of have a service tier and its mapped to the business entities.
 * 
 * @author scastellanos
 *
 */
public class GameInitDTO {

	/**
	 * Reresent the direction in which the rover start (N,E,S,W)
	 */
	private Direction direction;
	
	/**
	 * The x point of the grid in which the mars rover start
	 */
	private int currentCoordinateX;
	
	/**
	 * The y point of the grid in which the mars rover start
	 */
	private int currentCoordinateY;
	
	/**
	 * The top right length of the grid or planet
	 */
	private int topRight;
	
	/**
	 * The top left length of the grid or planet
	 */
	private	int topLeft;
	
	/**
	 * The list of obstacles objects that will putted in the grid.
	 */
	private List<ObstacleDTO> obstacles;
	
	/**
	 * A list of characters in order to by exeuted as a commands (F = move forward, B = move backward, R= turn right, L = turn left )
	 */
	private	String commands;
	/**
	 * @return the topLeft
	 */
	public int getTopLeft() {
		return topLeft;
	}
	/**
	 * @param topLeft the topLeft to set
	 */
	public void setTopLeft(int topLeft) {
		this.topLeft = topLeft;
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
	 * @return the topRight
	 */
	public int getTopRight() {
		return topRight;
	}
	/**
	 * @param topRight the topRight to set
	 */
	public void setTopRight(int topRight) {
		this.topRight = topRight;
	}
	/**
	 * @return the currentCoordinateX
	 */
	public int getCurrentCoordinateX() {
		return currentCoordinateX;
	}
	/**
	 * @param currentCoordinateX the currentCoordinateX to set
	 */
	public void setCurrentCoordinateX(int currentCoordinateX) {
		this.currentCoordinateX = currentCoordinateX;
	}
	/**
	 * @return the currentCoordinateY
	 */
	public int getCurrentCoordinateY() {
		return currentCoordinateY;
	}
	/**
	 * @param currentCoordinateY the currentCoordinateY to set
	 */
	public void setCurrentCoordinateY(int currentCoordinateY) {
		this.currentCoordinateY = currentCoordinateY;
	}
	/**
	 * @return the commands
	 */
	public String getCommands() {
		return commands;
	}
	/**
	 * @param commands the commands to set
	 */
	public void setCommands(String commands) {
		this.commands = commands;
	}
	/**
	 * @return the obstacles
	 */
	public List<ObstacleDTO> getObstacles() {
		return obstacles;
	}
	/**
	 * @param obstacles the obstacles to set
	 */
	public void setObstacles(List<ObstacleDTO> obstacles) {
		this.obstacles = obstacles;
	}
	
}
