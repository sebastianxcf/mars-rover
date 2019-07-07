package com.scastellanos.marsrover.commands;

import com.scastellanos.marsrover.domain.MarsRover;

public class CommandMoveFoward implements ICommand{

	@Override
	public void move(MarsRover rover){
		rover.moveFoward();;
		
	}

}
