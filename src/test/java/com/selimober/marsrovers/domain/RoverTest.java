package com.selimober.marsrovers.domain;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: so
 * Date: 6/14/13
 */
public class RoverTest {
    @Test
    public void executeCommand_shouldReturnPosition_whenGivenValidCommands() {
        // Arrange
        // initial position
        int x = 1;
        int y = 2;
        Position initialPosition = new Position(x, y, Direction.NORTH);

        // rover
        Rover sut = new Rover(initialPosition);

        // Act
        sut.executeCommand(Command.LEFT);
        sut.executeCommand(Command.MOVE);
        sut.executeCommand(Command.LEFT);
        sut.executeCommand(Command.MOVE);
        sut.executeCommand(Command.LEFT);
        sut.executeCommand(Command.MOVE);
        sut.executeCommand(Command.LEFT);
        sut.executeCommand(Command.MOVE);
        Position newPosition = sut.executeCommand(Command.MOVE);

        // Assert
        Position expectedPosition = new Position(1, 3, Direction.NORTH);
        Assert.assertEquals(expectedPosition, newPosition);
    }
}
