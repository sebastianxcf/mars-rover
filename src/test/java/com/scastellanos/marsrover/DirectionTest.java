package com.scastellanos.marsrover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scastellanos.marsrover.domain.Direction;
import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectionTest extends MarsRoverBaseTest {

	@Test
	public void testEastIsOnLeftOfNorth() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		String commands = "R";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.EAST, rover.getDirection());

	}

	@Test
	public void testWestIsOnTighttOfNorth() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		String commands = "L";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.WEST, rover.getDirection());

	}

	@Test
	public void testSouthIsOnRightOfEast() throws MoveException, CreationException {

		Direction direction = Direction.EAST;
		String commands = "R";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.SOUTH, rover.getDirection());

	}

	@Test
	public void testNorthIsOnTheLeftOfEast() throws MoveException, CreationException {

		Direction direction = Direction.EAST;
		String commands = "L";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.NORTH, rover.getDirection());

	}

	@Test
	public void testWestIsOnTheRightOfSouth() throws MoveException, CreationException {

		Direction direction = Direction.SOUTH;
		String commands = "R";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.WEST, rover.getDirection());

	}

	@Test
	public void testEastIsOnTheLeftOfSouth() throws MoveException, CreationException {

		Direction direction = Direction.SOUTH;
		String commands = "L";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.EAST, rover.getDirection());

	}

	@Test
	public void testSouthIsOnTheLeftOfWest() throws MoveException, CreationException {

		Direction direction = Direction.WEST;
		String commands = "L";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.SOUTH, rover.getDirection());
	}

	@Test
	public void testNorthIsOnTheRightOfWest() throws MoveException, CreationException {

		Direction direction = Direction.WEST;
		String commands = "R";
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		rover.play(commands);

		assertEquals(Direction.NORTH, rover.getDirection());

	}
}
