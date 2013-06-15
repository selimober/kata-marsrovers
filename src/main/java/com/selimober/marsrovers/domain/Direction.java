package com.selimober.marsrovers.domain;

/**
 * Represents direction commands given in input
 *
 * User: so
 * Date: 6/14/13
 */
public enum Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    int num;
    char abbr;

    private Direction(int num, char abbr) {
        this.num = num;
        this.abbr = abbr;
    }

    public Direction turn(Command turnCommand) {
        switch (turnCommand) {
            case LEFT:
                return Direction.values()[(num + 3) % 4];
            case RIGHT:
                return Direction.values()[(num + 1) % 4];
            default:
                throw new IllegalArgumentException("Arguments to turn command should be Command.LEFT or Command.RIGHT");
        }
    }

    public static Direction fromChar(char direction) {
        if (direction == NORTH.abbr) {
            return NORTH;
        } else if (direction == EAST.abbr) {
            return EAST;
        } else if (direction == SOUTH.abbr) {
            return SOUTH;
        } else if (direction == WEST.abbr) {
            return WEST;
        } else {
            throw new IllegalArgumentException("Direction should be 'N', 'E', 'S' or 'W'");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(abbr);
    }
}
