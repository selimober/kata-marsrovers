package com.selimober.marsrovers.domain;

import java.util.List;

/**
 * Immutable holder object to keep two lines of the input, initial position, and sequential commands
 *
 * User: so
 * Date: 6/14/13
 */
public class RoverInstruction {
    private Position initialPosition;
    private List<Command> commands;

    public RoverInstruction(Position initialPosition, List<Command> commands) {
        this.initialPosition = initialPosition;
        this.commands = commands;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
