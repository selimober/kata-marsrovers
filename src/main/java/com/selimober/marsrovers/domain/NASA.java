package com.selimober.marsrovers.domain;

import java.util.List;

/**
 * Main abstraction for the problem, not dependent to any input method.
 *
 * User: so
 * Date: 6/14/13
 */
public class NASA {
    private Plateau plateau;
    List<RoverInstruction> instructions;

    public NASA(Plateau plateau, List<RoverInstruction> instructions) {
        this.plateau = plateau;
        this.instructions = instructions;
    }

    public String startMission() {
        StringBuilder sb = new StringBuilder();
        for (RoverInstruction instruction : instructions) {
            Position position = sendRover(instruction);
            sb.append(position).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    private Position sendRover(RoverInstruction instruction) {
        Position initialPosition = instruction.getInitialPosition();
        Rover rover = new Rover(initialPosition);

        for (Command command : instruction.getCommands()) {
            if (isPositionInsidePlateauAfterCommand(rover.getPosition(), command)) {
                rover.executeCommand(command);
            } else {
                break;          // off the plateau, just stop there and don't move further.
            }
        }
        return rover.getPosition();
    }

    private boolean isPositionInsidePlateauAfterCommand(Position position, Command command) {
        if (command != Command.MOVE) {
            return true;        // every turn command is inside plateau
        }

        Position simulatedPosition = position.move();       // simulate next move

        int x = simulatedPosition.getX();
        int y = simulatedPosition.getY();
        if (x < 0 || x > plateau.getWidth() || y < 0 || y > plateau.getHeight()) {
            return false;
        } else {
            return true;
        }
    }
}
