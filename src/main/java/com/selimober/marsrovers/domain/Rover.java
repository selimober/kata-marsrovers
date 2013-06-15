package com.selimober.marsrovers.domain;

/**
 * Represents the mars rover. No knowledge of the plateau where it roams.
 * To execute commands, it delegates to Position and updates its new position.
 *
 * User: so
 * Date: 6/14/13
 */
public class Rover {

    private Position position;

    public Rover(Position initialPosition) {
        this.position = initialPosition;
    }

    public Position executeCommand(Command command) {
        switch (command) {
            case LEFT:
                position = position.turn(Command.LEFT);
                break;
            case RIGHT:
                position = position.turn(Command.RIGHT);
                break;
            case MOVE:
                position = position.move();
                break;
            default:
                throw new IllegalArgumentException("Command should be LEFT, RIGHT or MOVE");
        }

        return position;
    }

    public Position getPosition() {
        return position;
    }
}
