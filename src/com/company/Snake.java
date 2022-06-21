package com.company;

public class Snake {

    private Fruit head;
    private Fruit tail;
    private int size = 0;
    private Fruit turn;

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

    public void eat(Fruit fruit) {
        head.setNext(fruit);
        fruit.setPrevious(head);
        head = fruit;
    }

    public boolean hasCoordinate(Coordinate coordinate) {
        boolean result = false;
        Fruit current = tail;
        while (current.getNext() != null) {
            if (current.getCoordinates().equals(coordinate)) {
                result = true;
                break;
            }
            current = current.getNext();
        }
        return result;
    }

    public void moveRight(char direction) {
        if (direction == 'a') {
            System.out.println("Move Right is not available");
            direction = 'a';
        } else if (direction == 'd') {
            Fruit current = tail;
            while (current.getNext() != null) {
                current.getCoordinates().toRight();
                current = current.getNext();
            }
        } else if (direction == 's') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toDown();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toRight();
                current = current.getNext();
            }
            if (turn == tail) {
                turn = null;
            }
        } else if (direction == 'w') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toUp();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toRight();
                current = current.getNext();
            }
            if (turn == tail) {
                turn = null;
            }
        }
    }

    public void moveleft(char direction) {
        if (direction == 'd') {
            System.out.println("Move Left is not available");
            direction = 'd';
        } else if (direction == 'a') {
            Fruit current = tail;
            while (current.getNext() != null) {
                current.getCoordinates().toLeft();
                current = current.getNext();
            }
        } else if (direction == 's') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toDown();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toLeft();
                current = current.getNext();
            }
        } else if (direction == 'w') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toUp();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toLeft();
                current = current.getNext();
            }

        }
        if (turn == tail) {
            turn = null;
        }


    }

    public void moveDown(char direction) {
        if (direction == 'w') {
            System.out.println("Move Down is not available");
            direction = 'w';
        } else if (direction == 's') {
            Fruit current = tail;
            while (current.getNext() != null) {
                current.getCoordinates().toDown();
                current = current.getNext();
            }
        } else if (direction == 'd') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toRight();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toDown();
                current = current.getNext();
            }
        } else if (direction == 'a') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toLeft();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toDown();
                current = current.getNext();
            }
        }
        if (turn == tail) {
            turn = null;
        }

    }

    public void moveUp(char direction) {
        if (direction == 's') {
            System.out.println("Move Up is not available");
            direction = 's';
        } else if (direction == 'w') {
            Fruit current = tail;
            while (current.getNext() != null) {
                current.getCoordinates().toUp();
                current = current.getNext();
            }
        } else if (direction == 'd') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toRight();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toUp();
                current = current.getNext();
            }
        } else if (direction == 'a') {
            turn = head;
            Fruit current = tail;
            while (current.getNext() != turn) {
                current.getCoordinates().toLeft();
                current = current.getNext();
            }
            while (current.getNext() != null) {
                current.getCoordinates().toUp();
                current = current.getNext();
            }
        }
        if (turn == tail) {
            turn = null;
        }
    }

}

