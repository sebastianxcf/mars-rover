package com.scastellanos.marsrover.commands;

import com.scastellanos.marsrover.domain.MarsRover;

public interface ICommand {
	
	public void move(MarsRover rover);
}
