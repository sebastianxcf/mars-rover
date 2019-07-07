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
		
		MarsRover rover = new MarsRover(current, direction, grid);
		
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
	     
	    MarsRover rover = new MarsRover(current, direction, grid); 
	    rover.processCommand("F"); 
	    Coordinates expectedCoord = new Coordinates(2,0);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
	     
	  } 

}
