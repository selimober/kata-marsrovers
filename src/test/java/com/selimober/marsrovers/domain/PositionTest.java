package com.selimober.marsrovers.domain;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: so
 * Date: 6/14/13
 */
public class PositionTest {
    @Test
    public void turn_shouldTurnToSouth_whenFacingNorthAnd2RightCommandsGiven() {
        // Arrange
        int x = 1;
        int y = 1;
        Position sut = new Position(x, y, Direction.NORTH);

        // Act
        Position actual = sut.turn(Command.RIGHT);
        actual = actual.turn(Command.RIGHT);

        // Assert
        Position expected = new Position(1, 1, Direction.SOUTH);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void move_shouldMoveToNorth_whenFacingNorthAndMoveCommandGiven() {
        // Arrange
        int x = 1;
        int y = 1;
        Position sut = new Position(x, y, Direction.NORTH);

        // Act
        Position actual = sut.move();

        // Assert
        Position expected = new Position(1, 2, Direction.NORTH);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void move_shouldMoveToWest_whenFacingWestAndMoveCommandGiven() {
        // Arrange
        int x = 1;
        int y = 1;
        Position sut = new Position(x, y, Direction.WEST);

        // Act
        Position actual = sut.move();

        // Assert
        Position expected = new Position(0, 1, Direction.WEST);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void move_shouldMoveToSouth_whenFacingSouthAndMoveCommandGiven() {
        // Arrange
        int x = 1;
        int y = 1;
        Position sut = new Position(x, y, Direction.SOUTH);

        // Act
        Position actual = sut.move();

        // Assert
        Position expected = new Position(1, 0, Direction.SOUTH);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void move_shouldMoveToEast_whenFacingEastAndMoveCommandGiven() {
        // Arrange
        int x = 1;
        int y = 1;
        Position sut = new Position(x, y, Direction.EAST);

        // Act
        Position actual = sut.move();

        // Assert
        Position expected = new Position(2, 1, Direction.EAST);
        Assert.assertEquals(expected, actual);
    }
}
