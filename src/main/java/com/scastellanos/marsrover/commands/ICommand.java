package com.scastellanos.marsrover.commands;

import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.exceptions.MoveException;

@Component
public interface ICommand {
	
	public void move(MarsRover rover) throws MoveException;
}
