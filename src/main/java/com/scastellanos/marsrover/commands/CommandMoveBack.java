package com.scastellanos.marsrover.commands;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.exceptions.MoveException;

@Component
@Qualifier("back")
public class CommandMoveBack implements ICommand{

	@Override
	public void move(MarsRover rover) throws MoveException{
		rover.moveBack();
		
	}

}
