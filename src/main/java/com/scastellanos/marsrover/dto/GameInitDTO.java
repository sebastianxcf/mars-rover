package com.scastellanos.marsrover.dto;

import java.util.List;

import com.scastellanos.marsrover.domain.Direction;

public class GameInitDTO {

	private Direction direction;
	
	private int currentCoordinateX;
	
	private int currentCoordinateY;
	
	private int topRight;
	
	private	int topLeft;
	
	private List<ObstacleDTO> obstacles;
	
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
