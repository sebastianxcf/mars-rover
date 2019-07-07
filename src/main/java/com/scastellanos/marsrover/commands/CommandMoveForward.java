package com.scastellanos.marsrover.commands;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;

@Component
@Qualifier("forward")
public class CommandMoveForward implements ICommand{

	@Override
	public void move(MarsRover rover){
		rover.moveFoward();;
		
	}

}
