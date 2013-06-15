package com.selimober.marsrovers;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * User: so
 * Date: 6/15/13
 */
public class BootstrapTest {
    @Test
    public void start_shouldReturnExpectedOutput_whenInputInAFileGiven() throws URISyntaxException, IOException {
        // Arrange
        Bootstrap sut = new Bootstrap();
        File inputFile = new File(getClass().getClassLoader().getResource("instructions.txt").toURI());

        // Act
        String actual = sut.run(inputFile);

        // Assert
        String newLine = System.getProperty("line.separator");
        String expected = "1 3 N" + newLine + "5 1 E" + newLine;
        Assert.assertEquals(expected, actual);
    }
}
