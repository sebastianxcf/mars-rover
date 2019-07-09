package com.scastellanos.marsrover;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.parser.Parser;

public class MarsRoverBaseTest {

	@Autowired
	Parser parser;

	Coordinates current;

	Coordinates topRight;

	Coordinates bottomLeft;

	List<Obstacle> obstacles = new ArrayList();

	List<String> instructions;

	Grid grid;

	@Before
	public void init() throws CreationException {
		instructions = new ArrayList<String>();
		current = new Coordinates(0, 0);
		topRight = new Coordinates(10, 10);
		bottomLeft = new Coordinates(0, 0);
		grid = new Grid(bottomLeft, topRight, obstacles);
		parser.init();
	}

}
