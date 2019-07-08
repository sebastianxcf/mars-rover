package com.scastellanos.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Direction;
import com.scastellanos.marsrover.domain.Grid;
import com.scastellanos.marsrover.domain.MarsRover;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.exceptions.MoveException;
import com.scastellanos.marsrover.util.ErrorCodes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsRoverWallapopApplicationTests extends MarsRoverBaseTest {

	@Test
	public void testCreateNewRover() throws CreationException {
		instructions.add("R");
		instructions.add("F");

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		assertNotNull(rover);
	}

	@Test(expected = CreationException.class)
	public void testCreateNewRoverWithNullDirection() throws CreationException {

		instructions.add("R");
		instructions.add("F");
		instructions.add("B");

		Direction direction = null;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		assertNotNull(rover);
	}

	@Test(expected = CreationException.class)
	public void testCreateNewRoverWithOutOfBoundsCoordinates() throws CreationException {

		instructions.add("R");
		instructions.add("F");
		instructions.add("B");

		Direction direction = Direction.NORTH;
		current = new Coordinates(-1, -2);

		MarsRover rover = new MarsRover(current, direction, grid, parser);

		assertNotNull(rover);
	}

	@Test(expected = CreationException.class)
	public void testCreateNewRoverOverAnExistingObstacle() throws CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));

		obstacles.add(o);
		grid = new Grid(bottomLeft, topRight, obstacles);

		current = new Coordinates(2, 0);
		Direction direction = Direction.NORTH;

		MarsRover rover = new MarsRover(current, direction, grid, parser);

		assertNotNull(rover);
	}

	// MOVE ROVER TEST

	@Test(expected = MoveException.class)
	public void testIncorrectCommands() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String commands = "A";
		rover.play(commands);
	}

	@Test(expected = MoveException.class)
	public void testEmptyCommand() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String commands = "";
		rover.play(commands);
	}

	@Test(expected = MoveException.class)
	public void testMalformedCommand() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String commands = "F  A";
		rover.play(commands);
	}

	@Test
	public void testMoveRoverForward() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String commands = "F";
		rover.play(commands);

		Coordinates expectedCoord = new Coordinates(0, 1);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());

	}

	@Test
	public void testMoveRoverBackward() throws MoveException, CreationException {

		Direction direction = Direction.NORTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String commands = "FB";
		rover.play(commands);

		Coordinates expectedCoord = new Coordinates(0, 0);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());

	}

	@Test(expected = MoveException.class)
	public void testObstacleDetection() throws MoveException, CreationException {
		Obstacle o = new Obstacle();
		o.setCoordinate(new Coordinates(2, 0));
		obstacles.add(o);

		Grid grid = new Grid(bottomLeft, topRight, obstacles);

		Direction direction = Direction.EAST;

		MarsRover rover = new MarsRover(current, direction, grid, parser);

		try {
			String commands = "FF";
			rover.play(commands);
		} catch (MoveException e) {
			assertEquals(ErrorCodes.MR_MOVE_102.getValue(), e.getCode());
			// Check that validate the position before move.
			assertEquals(new Integer(1), rover.getCoordinates().getCordinateX());
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateY());
			throw e;
		}

	}

	@Test(expected = MoveException.class)
	public void testOutOfBoundMove() throws MoveException, CreationException {
		Direction direction = Direction.SOUTH;
		MarsRover rover = new MarsRover(current, direction, grid, parser);

		try {
			String command = "F";
			rover.play(command);
		} catch (MoveException e) {
			assertEquals(ErrorCodes.MR_MOVE_101.getValue(), e.getCode());
			// Check that validate the position before move.
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateX());
			assertEquals(new Integer(0), rover.getCoordinates().getCordinateY());
			throw e;
		}

	}

	@Test
	public void testExecuteMoreThanOneCommandCorrect() throws MoveException, CreationException {
		Direction direction = Direction.NORTH;

		MarsRover rover = new MarsRover(current, direction, grid, parser);

		String command = "FFFRFFFRB";
		rover.play(command);

		Coordinates expectedCoord = new Coordinates(3, 4);
		assertEquals(expectedCoord.getCordinateX(), rover.getCoordinates().getCordinateX());
		assertEquals(expectedCoord.getCordinateY(), rover.getCoordinates().getCordinateY());
	}

}
