package com.selimober.marsrovers.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: so
 * Date: 6/14/13
 */
public class DirectionTest {
    @Test
    public void turn_shouldTurnToWest_whenFacingNorthAndLeftCommandGiven() {
        // Arrange
        Direction sut = Direction.NORTH;

        // Act
        Direction actual = sut.turn(Command.LEFT);

        // Assert
        Direction expected = Direction.WEST;
        assertEquals(expected, actual);
    }

    @Test
    public void turn_shouldTurnToSouth_whenFacingEastAndRightCommandGiven() {
        // Arrange
        Direction sut = Direction.EAST;

        // Act
        Direction actual = sut.turn(Command.RIGHT);

        // Assert
        Direction expected = Direction.SOUTH;
        assertEquals(expected, actual);
    }
}
