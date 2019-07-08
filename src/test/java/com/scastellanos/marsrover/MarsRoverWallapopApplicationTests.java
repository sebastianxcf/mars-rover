package com.scastellanos.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Direction;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.parser.Parser;
import com.scastellanos.marsrover.util.ErrorCodes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsRoverWallapopApplicationTests {
	
	@Autowired
	Parser parser;

	Coordinates current;
	
	Coordinates topRight;
	
	Coordinates topLeft;
	
	List<Obstacle> obstacles = new ArrayList();
	
	Grid grid;
	
	@Before
	public void init() throws CreationException {
		current = new Coordinates(0,0);
		topRight = new Coordinates(10,10);
		topLeft = new Coordinates(0,0);
		grid = new Grid(topLeft,topRight,obstacles);
		parser.init();
	}
	
	
	@Test
	public void testCreateNewRover() throws CreationException{
		List<String> instructions = new ArrayList();
		instructions.add("R");
		instructions.add("F");
		instructions.add("F");
		instructions.add("L");
		instructions.add("F");
		instructions.add("B");

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		assertNotNull(rover);
	}
	
	//1 normal create
	//2 crate with null direction
	//3 create with out of bounds coordinates
	//4 create obstacle in wrong position
	//5 create with invalid grid.
	
	
	@Test
	public void testMoveRoverFoward() throws MoveException, CreationException{
		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid,parser);

		String commands = "F";
		rover.play(commands);
		
		Coordinates expectedCoord = new Coordinates(0,1);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());
		
	}
	
	@Test
	public void testTurnRoverRight() throws MoveException, CreationException{
		
		Direction direction = Direction.NORTH;
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		String commands = "R";
		rover.play(commands);
		
		assertEquals(Direction.EAST, rover.getDirection());
		
	}
	
	@Test
	public void testTurnRoverLeft() throws MoveException, CreationException{
		
		Direction direction = Direction.NORTH;
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		String commands = "L";
		rover.play(commands);
		
		assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test
	public void testMoveRoverBack() throws MoveException, CreationException {
		
		Direction direction = Direction.WEST;
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		String commands = "B";
		rover.play(commands);
		
		Coordinates expectedCoord = new Coordinates(1,0);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());
		
	}

	@Test(expected= MoveException.class)
	public void testObstacleDetection() throws MoveException, CreationException{
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.EAST;
		
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		try {
			String commands = "FF";
			rover.play(commands);
		}catch(MoveException e) {
			assertEquals(ErrorCodes.MR_MOVE_102.getValue(), e.getCode());
			//Check that validate the position before move.
			assertEquals(new Integer(1), rover.getCoordinates().getCordinateX());
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateY());
			throw e;
		}
		
	}
	
	@Test(expected= MoveException.class)
	public void testOutOfBoundMove() throws MoveException, CreationException{
		Direction direction = Direction.SOUTH;
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		try {
			String command = "F";
			rover.play(command);
		}catch(MoveException e) {
			assertEquals(ErrorCodes.MR_MOVE_101.getValue(), e.getCode());
			//Check that validate the position before move.
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateX());
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateY());
			throw e;
		}
		
	}
	
	@Test
	public void testExecuteMoreThanOneCommand() throws MoveException, CreationException{
		Direction direction = Direction.NORTH;
		
		parser.init();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
			String command = "FFF";
			rover.play(command);
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateX());
			assertEquals(new Integer(3), rover.getCoordinates().getCordinateY());
	}
	
	
}
