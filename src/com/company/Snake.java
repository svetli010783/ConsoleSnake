package com.company;

public class Snake {

    private Fruit head;
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

    public void eat(Fruit fruit) {
        head.setNext(fruit);
        fruit.setPrevious(head);
        head = fruit;
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

    public void moveRight(char direction) {
        if (direction == 'a') {
            System.out.println("Move Right is not available");
            direction = 'a';
        }  else if (direction == 'w'||direction == 's'||direction == 'd') {
            Fruit current = head;
            Fruit a = current;
            Fruit b;
            current.getCoordinates().toRight();
            while (current.getPrevious() != null) {
                b = current.getPrevious();
                current.getPrevious().setCoordinates(a.getCoordinates());
                current = b;
            }
        }
    }

    public void moveleft(char direction) {
        if (direction == 'd') {
            System.out.println("Move Left is not available");
            direction = 'd';
        }  else if (direction == 'w'||direction == 'a'||direction == 's') {
            Fruit current = head;
            Fruit a = current;
            Fruit b;
            current.getCoordinates().toLeft();
            while (current.getPrevious() != null) {
                b = current.getPrevious();
                a = current.getPrevious();
                current.getPrevious().setCoordinates(a.getCoordinates());
                current = b;
            }
        }

    }

    public void moveDown(char direction) {
        if (direction == 'w') {
            System.out.println("Move Down is not available");
            direction = 'w';
        }  else if (direction == 's'||direction == 'a'||direction == 'd') {
            Fruit current = head;
            Fruit a = current;
            Fruit b;
            current.getCoordinates().toDown();
            while (current.getPrevious() != null) {
                b = current.getPrevious();
                a = current.getPrevious();
                current.getPrevious().setCoordinates(a.getCoordinates());
                current = b;
            }
        }
    }

    public void moveUp(char direction) {
        if (direction == 's') {
            System.out.println("Move Up is not available");
            direction = 's';
        } else if (direction == 'w'||direction == 'a'||direction == 'd') {
            Fruit current = head;
            Fruit a = current;
            Fruit b;
            current.getCoordinates().toUp();
            while (current.getPrevious() != null) {
                b = current.getPrevious();
                current.getPrevious().setCoordinates(a.getCoordinates());
                current = b;
            }
        }


    }

}

