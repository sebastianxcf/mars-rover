package com.scastellanos.marsrover.commands;

import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.exceptions.MoveException;

@Component
public interface ICommand {
	/**
	 * This are the possible commands to execute by the client
	 */
	String R = "R";
	String L = "L";
	String F = "F";
	String B = "B";
	
	public void move(MarsRover rover) throws MoveException;
}
