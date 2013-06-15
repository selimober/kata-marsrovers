package com.selimober.marsrovers.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: so
 * Date: 6/15/13
 */
public class CommandTest {
    @Test
    public void fromChar_shouldReturnLeft_whenLGiven() {
        // Arrange
        Command sut = Command.fromChar('L');

        // Assert
        Command expected = Command.LEFT;
        assertEquals(expected, sut);
    }
}
