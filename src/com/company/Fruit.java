package com.company;

public class Fruit {
    private Coordinate coordinates;
    private Fruit previous;
    private Fruit next;


    public boolean hasCoordinate(Coordinate coordinate) {
        boolean result = false;
        if (this.getCoordinates().equals(coordinate)) {
            result = true;
        }

        return result;
    }
    public  void changeOfCoordinates( int width, int height){
        if (this.getCoordinates().getX() == width) {
            this.getCoordinates() .setX(1);
        } else if (this.getCoordinates().getX() == 0) {
            this.getCoordinates().setX(--width);
        }
        if (this.getCoordinates().getY() == height) {
            this.getCoordinates().setY(1);
        } else if (this.getCoordinates().getY() == 0) {
            this.getCoordinates().setY(--height);
        }
    }


    public Fruit(Coordinate coordinates, Fruit previous, Fruit next) {
        this.coordinates = coordinates;
        this.previous = previous;
        this.next = next;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

    public Fruit getPrevious() {
        return previous;
    }

    public void setPrevious(Fruit previous) {
        this.previous = previous;
    }

    public Fruit getNext() {
        return next;
    }

    public void setNext(Fruit next) {
        this.next = next;
    }
}
