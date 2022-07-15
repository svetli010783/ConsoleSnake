package com.company;

public class Snake {

    private static Fruit head;
    private Fruit tail;
    private int size = 0;

    public Snake(int width, int height) {
        head = new Fruit(
                new Coordinate(width / 2 - 7, height / 2),
                null,
                null
        );
        tail = head;
        size++;

        for (int i = 0; i < 7; i++) {
            Fruit newFruit = new Fruit(
                    new Coordinate(head.getCoordinates().getX() + 1, head.getCoordinates().getY()),
                    head,
                    null
            );
            head.setNext(newFruit);
            head = newFruit;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public boolean eat(Fruit fruit,boolean hasFruit) {
        hasFruit = false;
        head.setNext(fruit);
        fruit.setPrevious(head);
        head = fruit;
       return hasFruit;

    }

    public boolean hasCoordinate(Coordinate coordinate) {
        boolean result = false;
        Fruit current = head;

        while (current.getPrevious() != null) {
            if (current.getCoordinates().equals(coordinate)) {
                result = true;
                break;
            }
            current = current.getPrevious();
        }
        return result;
    }

    public boolean death (Fruit eat){
        boolean result = false;
        Fruit current = head.getPrevious();

        while (current.getPrevious() != null) {
            if (current.getCoordinates().equals(head.getCoordinates())
                    && head.getCoordinates() != eat.getCoordinates()) {
                result = true;
                break;
            }
            current = current.getPrevious();
        }
        return result;
    }

    public  void changeOfCoordinates( int width, int height){
        Fruit current = head;
        if (current.getCoordinates().getX() == width) {
            current.getCoordinates() .setX(1);
        } else if (current.getCoordinates().getX() == 0) {
            current.getCoordinates().setX(--width);
        }
        if (current.getCoordinates().getY() == height) {
            current.getCoordinates().setY(1);
        } else if (current.getCoordinates().getY() == 0) {
            current.getCoordinates().setY(--height);
        }
    }

    public void moveRight() {
        Fruit current = head;
        int tempX1 = current.getCoordinates().getX();
        int tempY1 = current.getCoordinates().getY();
        int tempX2;
        int tempY2;
        current.getCoordinates().toRight();
        while (current.getPrevious() != null) {
            tempX2 = current.getPrevious().getCoordinates().getX();
            tempY2 = current.getPrevious().getCoordinates().getY();
            current.getPrevious().setCoordinates(tempX1, tempY1);
            current = current.getPrevious();
            tempX1 = tempX2;
            tempY1 = tempY2;

        }

    }

    public void moveleft() {
        Fruit current = head;
        int tempX1 = current.getCoordinates().getX();
        int tempY1 = current.getCoordinates().getY();
        int tempX2;
        int tempY2;
        current.getCoordinates().toLeft();
        while (current.getPrevious() != null) {
            tempX2 = current.getPrevious().getCoordinates().getX();
            tempY2 = current.getPrevious().getCoordinates().getY();
            current.getPrevious().setCoordinates(tempX1, tempY1);
            current = current.getPrevious();
            tempX1 = tempX2;
            tempY1 = tempY2;


        }

    }

    public void moveDown() {
        Fruit current = head;
        int tempX1 = current.getCoordinates().getX();
        int tempY1 = current.getCoordinates().getY();
        int tempX2;
        int tempY2;
        current.getCoordinates().toDown();
        while (current.getPrevious() != null) {
            tempX2 = current.getPrevious().getCoordinates().getX();
            tempY2 = current.getPrevious().getCoordinates().getY();
            current.getPrevious().setCoordinates(tempX1, tempY1);
            current = current.getPrevious();
            tempX1 = tempX2;
            tempY1 = tempY2;


        }
    }

    public void moveUp() {
        Fruit current = head;
        int tempX1 = current.getCoordinates().getX();
        int tempY1 = current.getCoordinates().getY();
        int tempX2;
        int tempY2;
        current.getCoordinates().toUp();
        while (current.getPrevious() != null) {
            tempX2 = current.getPrevious().getCoordinates().getX();
            tempY2 = current.getPrevious().getCoordinates().getY();
            current.getPrevious().setCoordinates(tempX1, tempY1);
            current = current.getPrevious();
            tempX1 = tempX2;
            tempY1 = tempY2;
        }
    }

    public  Fruit getHead() {
        return head;
    }
}



