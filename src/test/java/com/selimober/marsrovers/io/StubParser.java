package com.selimober.marsrovers.io;

import com.selimober.marsrovers.domain.*;

import java.util.Arrays;
import java.util.List;

/**
 * User: so
 * Date: 6/14/13
 */
public class StubParser implements Parser {
    @Override
    public Plateau parsePlateau() {
        return new Plateau(5, 5);
    }

    @Override
    public List<RoverInstruction> parseInstructionList() {
        return Arrays.asList(
                new RoverInstruction(
                        new Position(1, 2, Direction.NORTH),
                        Arrays.asList(Command.LEFT, Command.MOVE, Command.LEFT, Command.MOVE, Command.LEFT, Command.MOVE,
                                Command.LEFT, Command.MOVE, Command.MOVE)
                ),
                new RoverInstruction(
                        new Position(3, 3, Direction.EAST),
                        Arrays.asList(Command.MOVE, Command.MOVE, Command.RIGHT, Command.MOVE, Command.MOVE, Command.RIGHT,
                                Command.MOVE, Command.RIGHT, Command.RIGHT, Command.MOVE)
                )
        );
    }
}
