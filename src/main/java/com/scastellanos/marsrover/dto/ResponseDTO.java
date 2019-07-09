package com.scastellanos.marsrover.dto;

/**
 * This class respresent the response of execute a set of commands. It contains the initial coordinates of the rove and the finals after process the commands.
 * @author scastellanos
 *
 */
public class ResponseDTO {

	
	/**
	 * The char list of commands to process.
	 */
	private String commands;
	
	/**
	 * The init x coordinate
	 */
	private int initCoordinateX;
	
	/**
	 * The init y coordinate
	 */
	private int initCoordinateY;
	
	/**
	 * The final x coordinate afte apply all the possible moves
	 */
	private int finalCoordinateX;
	
	/**
	 * The final x coordinate afte apply all the possible moves
	 */
	private int finalCoordinateY;
	
	
	/**
	 * @return the initCoordinateX
	 */
	public int getInitCoordinateX() {
		return initCoordinateX;
	}
	/**
	 * @param initCoordinateX the initCoordinateX to set
	 */
	public void setInitCoordinateX(int initCoordinateX) {
		this.initCoordinateX = initCoordinateX;
	}
	/**
	 * @return the initCoordinateY
	 */
	public int getInitCoordinateY() {
		return initCoordinateY;
	}
	/**
	 * @param initCoordinateY the initCoordinateY to set
	 */
	public void setInitCoordinateY(int initCoordinateY) {
		this.initCoordinateY = initCoordinateY;
	}
	/**
	 * @return the finalCoordinateX
	 */
	public int getFinalCoordinateX() {
		return finalCoordinateX;
	}
	/**
	 * @param finalCoordinateX the finalCoordinateX to set
	 */
	public void setFinalCoordinateX(int finalCoordinateX) {
		this.finalCoordinateX = finalCoordinateX;
	}
	/**
	 * @return the finalCoordinateY
	 */
	public int getFinalCoordinateY() {
		return finalCoordinateY;
	}
	/**
	 * @param finalCoordinateY the finalCoordinateY to set
	 */
	public void setFinalCoordinateY(int finalCoordinateY) {
		this.finalCoordinateY = finalCoordinateY;
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
	
}
