package com.selimober.marsrovers.domain;

/**
 * Represents every possible command: L for Left, R for Right and M for Move
 *
 * User: so
 * Date: 6/14/13
 */
public enum Command {
    LEFT,
    RIGHT,
    MOVE;

    public static Command fromChar(char command) {
        if (command == 'L') {
            return LEFT;
        } else if (command == 'R') {
            return RIGHT;
        } else if (command == 'M') {
            return MOVE;
        } else {
            throw new IllegalArgumentException("Command should be 'L', 'R' or 'M'");
        }
    }
}
