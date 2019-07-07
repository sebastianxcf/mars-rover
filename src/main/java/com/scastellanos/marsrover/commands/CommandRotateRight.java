package com.scastellanos.marsrover.commands;

import com.scastellanos.marsrover.domain.MarsRover;

public class CommandRotateRight implements ICommand{

	@Override
	public void move(MarsRover rover) {
		rover.turnRight();
		
	}

}
