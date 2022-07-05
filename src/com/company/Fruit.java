package com.company;

public class Fruit {
    private Coordinate coordinates;
    private Fruit previous;
    private Fruit next;


    public Fruit(Coordinate coordinates, Fruit previous, Fruit next) {
        this.coordinates = coordinates;
        this.previous = previous;
        this.next = next;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x,int y) {
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
