package com.scastellanos.marsrover.domain;

import com.scastellanos.marsrover.commands.CommandMoveBack;
import com.scastellanos.marsrover.commands.CommandMoveFoward;
import com.scastellanos.marsrover.commands.CommandRotateLeft;
import com.scastellanos.marsrover.commands.CommandRotateRight;
import com.scastellanos.marsrover.commands.ICommand;

public class MarsRover {

	private Coordinates coordinates;

	private Direction direction;

	private Grid grid;

	private ICommand command;

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
		this.getCoordinates().setCordinateX(2);
		System.out.println("We are in position > " + this.coordinates.toString());
	};

	public void moveBack() {
		System.out.println("We are in position > " + this.coordinates.toString());
	};

	public void processCommand(String instruction) {
		// TODO Improve the way of instantiate Commands
		switch (instruction) {
		case "F":
			command = new CommandMoveFoward();
			command.move(this);
			break;
		case "B":
			command = new CommandMoveBack();
			command.move(this);
			break;
		case "L":
			command = new CommandRotateLeft();
			command.move(this);
			break;
		case "R":
			command = new CommandRotateRight();
			command.move(this);
			break;
		default:
			break;
		}
		System.out.println("Instruction " + instruction);
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
	};

}
