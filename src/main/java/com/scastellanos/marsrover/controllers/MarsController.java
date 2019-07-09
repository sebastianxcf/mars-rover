package com.scastellanos.marsrover.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Direction;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.dto.GameInitDTO;
import com.scastellanos.marsrover.dto.ResponseDTO;
import com.scastellanos.marsrover.dto.RestResponseDTO;
import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.parser.Parser;
import com.scastellanos.marsrover.utils.Util;

@Controller
@RequestMapping("/mars")
public class MarsController {
	
	private static final Logger logger = LoggerFactory.getLogger(MarsController.class);
	
	@Autowired
	Parser parser;

	MarsRover rover;
	
	
	
	@RequestMapping(value="/move", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RestResponseDTO> createNewGame(@RequestBody GameInitDTO game) {
		ResponseDTO response = new ResponseDTO();

		try {
			
			Coordinates coordinates = new Coordinates(game.getCurrentCoordinateX(),game.getCurrentCoordinateY());
			Coordinates coordinatesTopRight = new Coordinates(game.getTopRight(),game.getTopLeft());
			Coordinates coordinatesBottomLeft = new Coordinates(0,0);
			
			Direction direction = game.getDirection();

			List<Obstacle> obstacles = Util.convertObstacleDtoTOEntity(game.getObstacles());
			
			Grid grid = new Grid(coordinatesBottomLeft,coordinatesTopRight, obstacles);
			
			parser.init();
			
			rover = new MarsRover(coordinates, direction, grid, parser);
			
			response.setInitCoordinateX(coordinates.getCordinateX());
			response.setInitCoordinateY(coordinates.getCordinateY());
			response.setCommands(game.getCommands());
			
			Coordinates finalCoordinates = rover.play(game.getCommands());
			 
			response.setFinalCoordinateX(finalCoordinates.getCordinateX());
			response.setFinalCoordinateY(finalCoordinates.getCordinateY());

		} catch (CreationException|MoveException e) {
			
			logger.error("{}:{}",e.getCode(),e.getMessage());
			return new ResponseEntity<RestResponseDTO>(new RestResponseDTO(e.getCode() , e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		return new ResponseEntity<RestResponseDTO>(new RestResponseDTO(response), HttpStatus.OK);
	}

	
}
