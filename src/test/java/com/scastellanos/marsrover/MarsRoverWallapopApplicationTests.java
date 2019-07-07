package com.scastellanos.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Direction;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.domain.Parser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsRoverWallapopApplicationTests {

	@Test
	public void testCreateNewRover(){
		List<String> instructions = new ArrayList();
		instructions.add("R");
		instructions.add("F");
		instructions.add("F");
		instructions.add("L");
		instructions.add("F");
		instructions.add("B");

		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.NORTH;
		Coordinates current = new Coordinates(0,0);
		
		Coordinates topRight = new Coordinates(10,10);
		Coordinates topLeft = new Coordinates(0,0);
		
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		Parser parser = new Parser();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		assertNotNull(rover);
	
	}
	
	@Test
	public void testMoveRoverFoward(){
		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.NORTH;
		Coordinates current = new Coordinates(0,0);
		
		Coordinates topRight = new Coordinates(10,10);
		Coordinates topLeft = new Coordinates(0,0);
		
		Grid grid = new Grid(topLeft,topRight,obstacles);

		Parser parser = new Parser();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		rover.processCommand("F");
		Coordinates expectedCoord = new Coordinates(0,1);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());
		
	}
	
	@Test
	public void testTurnRoverRight(){
		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.NORTH;
		Coordinates current = new Coordinates(0,0);
		
		Coordinates topRight = new Coordinates(10,10);
		Coordinates topLeft = new Coordinates(0,0);
		
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		Parser parser = new Parser();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		rover.processCommand("R");
		
		assertEquals(Direction.EAST, rover.getDirection());
		
	}
	
	@Test
	public void testTurnRoverLeft(){
		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.NORTH;
		Coordinates current = new Coordinates(0,0);
		
		Coordinates topRight = new Coordinates(10,10);
		Coordinates topLeft = new Coordinates(0,0);
		
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		Parser parser = new Parser();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		rover.processCommand("L");
		
		assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test
	public void testMoveRoverBack(){
		List<Obstacle> obstacles = new ArrayList();
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);
		
		Direction direction = Direction.WEST;
		Coordinates current = new Coordinates(0,0);
		
		Coordinates topRight = new Coordinates(10,10);
		Coordinates topLeft = new Coordinates(0,0);
		
		Grid grid = new Grid(topLeft,topRight,obstacles);
		
		Parser parser = new Parser();
		
		MarsRover rover = new MarsRover(current, direction, grid,parser);
		
		rover.processCommand("B");
		Coordinates expectedCoord = new Coordinates(1,0);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());
		
	}

}
