package com.selimober.marsrovers.domain;

/**
 * Represents postion, immutable, every new command creates a new position.
 *
 * User: so
 * Date: 6/14/13
 */
public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position turn(Command turnCommand) {
        return new Position(x, y, direction.turn(turnCommand));
    }

    public Position move() {
        switch (direction) {
            case NORTH:
                return new Position(x, y + 1, direction);
            case EAST:
                return new Position(x + 1, y, direction);
            case SOUTH:
                return new Position(x, y - 1, direction);
            case WEST:
                return new Position(x - 1, y, direction);
            default:
                throw new IllegalArgumentException("Direction should be one of four main directions");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;

        Position position = (Position) obj;

        if (x != position.x) return false;
        if (y != position.y) return false;
        if (direction != position.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
