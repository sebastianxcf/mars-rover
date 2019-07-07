package com.scastellanos.marsrover.domain;

import java.util.HashMap;
import java.util.Map;

import com.scastellanos.marsrover.commands.CommandMoveBack;
import com.scastellanos.marsrover.commands.CommandMoveFoward;
import com.scastellanos.marsrover.commands.CommandRotateLeft;
import com.scastellanos.marsrover.commands.CommandRotateRight;
import com.scastellanos.marsrover.commands.ICommand;

/**
 * This class manage all related with parser the commands. Transform a given
 * string command in a command.
 * 
 * @author scastellanos
 *
 */
public class Parser {

	Map<String, ICommand> commands = new HashMap<String, ICommand>();

	private ICommand commandRotateRight;

	private ICommand commandRotateLeft;

	private ICommand commandMoveFoward;

	private ICommand commandMoveBack;

	public Parser() {
		commands.put("R", commandRotateRight = new CommandRotateRight());
		commands.put("L", commandRotateLeft = new CommandRotateLeft());
		commands.put("F", commandMoveFoward = new CommandMoveFoward());
		commands.put("B", commandMoveBack = new CommandMoveBack());

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
