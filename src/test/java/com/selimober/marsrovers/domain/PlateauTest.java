package com.selimober.marsrovers.domain;

import org.junit.Test;

/**
 * User: so
 * Date: 6/14/13
 */
public class PlateauTest {
    @Test(expected = IllegalArgumentException.class)
    public void new_shouldThrowException_whenGivenNegativeWidth() {
        // Arrange
        int width = -1;
        int height = 2;
        Plateau sut = new Plateau(width, height);
    }

    @Test(expected = IllegalArgumentException.class)
    public void new_shouldThrowException_whenGivenZeroHeight() {
        // Arrange
        int width = 1;
        int height = 0;
        Plateau sut = new Plateau(width, height);

    }
}
