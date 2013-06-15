package com.selimober.marsrovers.domain;

import com.selimober.marsrovers.io.Parser;
import com.selimober.marsrovers.io.StubParser;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * User: so
 * Date: 6/14/13
 */
public class NASATest {
    @Test
    public void startMission_shouldReturnCorrectOutput_whenValidInputGiven() throws URISyntaxException {
        // Arrange
        Parser parser = new StubParser();
        Plateau stubPlateau = parser.parsePlateau();
        List<RoverInstruction> stubInstructionList = parser.parseInstructionList();
        NASA sut = new NASA(stubPlateau, stubInstructionList);

        // Act
        String actual = sut.startMission();

        // Assert
        String newLine = System.getProperty("line.separator");
        String expected = "1 3 N" + newLine + "5 1 E" + newLine;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void startMission_shouldNotMoveOffTheGrid_whenSuchCommandsGiven() {
        // Arrange
        Plateau plateau = new Plateau(3, 3);
        List<RoverInstruction> instructionsList = Arrays.asList(new RoverInstruction(
                new Position(1,1, Direction.EAST),
                Arrays.asList(Command.MOVE, Command.MOVE, Command.MOVE, Command.MOVE, Command.MOVE, Command.MOVE)
        ));
        NASA sut = new NASA(plateau, instructionsList);

        // Act
        String actual = sut.startMission();

        // Assert
        String newLine = System.getProperty("line.separator");
        String expected = "3 1 E" + newLine;
        Assert.assertEquals(expected, actual);
    }
}
