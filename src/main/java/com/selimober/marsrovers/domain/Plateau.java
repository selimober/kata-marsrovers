package com.selimober.marsrovers.domain;

/**
 * Represents a rectangular plateau, its height or width cannot be lesser than 1
 *
 * User: so
 * Date: 6/14/13
 */
public class Plateau {
    private int width;
    private int height;

    public Plateau(int width, int height) {
        if (width <= 0) throw new IllegalArgumentException("Width needs to be greater than zero");
        if (height <= 0) throw new IllegalArgumentException("Height needs to be greater than zero");

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
