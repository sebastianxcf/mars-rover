package com.scastellanos.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.exceptions.CreationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GridTest extends MarsRoverBaseTest {

	@Test(expected = CreationException.class)
	public void testCreateObstacleWithXPositionMayorThanXBorder() throws CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(20, 0));

		obstacles.add(o);
		grid = new Grid(bottomLeft, topRight, obstacles);
	}

	@Test(expected = CreationException.class)
	public void testCreateObstacleWithXPositionMinorThanXBorder() throws CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(-10, 0));

		obstacles.add(o);
		grid = new Grid(bottomLeft, topRight, obstacles);
	}

	@Test(expected = CreationException.class)
	public void testCreateObstacleWithYPositionMayorThanYBorder() throws CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(0, 20));

		obstacles.add(o);
		grid = new Grid(bottomLeft, topRight, obstacles);
	}

	@Test(expected = CreationException.class)
	public void testCreateObstacleWithYPositionMinorThanYBorder() throws CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(0, -20));

		obstacles.add(o);
		grid = new Grid(bottomLeft, topRight, obstacles);
	}

}
