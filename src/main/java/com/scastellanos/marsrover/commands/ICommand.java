package com.scastellanos.marsrover.commands;

import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.domain.MarsRover;

@Component
public interface ICommand {
	
	public void move(MarsRover rover);
}
