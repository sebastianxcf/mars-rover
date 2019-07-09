package com.scastellanos.marsrover.commands;

import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.exceptions.MoveException;

/**
 * This inteface represent the definition of commands in order to represent the command design pattern.
 * @author scastellanos
 *
 */
@Component
public interface ICommand {
	
	/**
	 * This are the possible commands to execute by the client
	 */
	String R = "R";
	String L = "L";
	String F = "F";
	String B = "B";
	
	/**
	 * Definition of move function. Receive a MarsRover object and depending of the implementation will execute one move or another.
	 * @param rover
	 * @throws MoveException
	 */
	public void move(MarsRover rover) throws MoveException;
}
