package com.company;

public class Coordinate implements Moveble {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void toRight() {
        this.x++;
    }

    @Override
    public void toLeft() {
        this.x--;
    }

    @Override
    public void toUp() {
        this.y--;
    }

    @Override
    public void toDown() {
        this.y++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }
}
