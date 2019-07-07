package com.scastellanos.marsrover.parser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.scastellanos.marsrover.commands.ICommand;

/**
 * This class manage all related with parser the commands. Transform a given
 * string command in a command.
 * 
 * @author scastellanos
 *
 */
@Component
public class Parser {

	Map<String, ICommand> commands = new HashMap<String, ICommand>();

	
	@Autowired
	@Qualifier("right")
	private ICommand commandRotateRight;
	
	@Autowired
	@Qualifier("left")
	private ICommand commandRotateLeft;
	
	@Autowired
	@Qualifier("forward")
	private ICommand commandMoveForward;
	
	@Autowired
	@Qualifier("back")
	private ICommand commandMoveBack;

	public Parser() {
	}
	
	public void init() {
		commands.put("R",commandRotateRight);
		commands.put("L",commandRotateLeft);
		commands.put("F",commandMoveForward);
		commands.put("B",commandMoveBack);
	}
	/**
	 * @return the commands
	 */
	public Map<String, ICommand> getCommands() {
		return commands;
	}

	/** 
	   * @param commands the commands to set 
	   */ 
	  public void setCommands(Map<String, ICommand> commands) { 
	    this.commands = commands; 
	  }
	  
	  
}
