package com.company;

public class Snake implements Moveble {

    private static Fruit head;
    private Fruit tail;
    private int size = 0;

    /**
     * метод создания змеи. Ширинна и высота передаются в данный метод для того чтобы
     * змейка изначально имела координаты середины игрового поля
     *
     * @param width ширина игрового поля
     * @param height высота игрового поля
     */
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

    /**
     * этот метод при его срабатывании делает съеденный фрукт новой головой,
     * за счет чег оувеличивается размер змейки
     *
     * @param fruit фрукт который съедает змея
     */
    public void eat(Fruit fruit) {
        head.setNext(fruit);
        fruit.setPrevious(head);
        head = fruit;
    }

    /**
     * метод проверки наличия части змеи в точке переданных координат
     *
     * @param coordinate координаты игрового поля
     * @return резулт проверки
     */
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

    /**
     * метод проверки того жива ли змея
     *
     * @param eat в данный метод передается фрукт из за того,
     * что во время удлиннения змеи ее часть на время одной итерации рендеринга совпадает с головой
     * (что и считается смертью),
     * а передавая фрукт в метод эта ситуацию исключается
     * @return резулт проверки
     */
    public boolean isDeath(Fruit eat) {
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

    /**
     * метод который изменяет коордитаты змеи при проходе сквозь стену,
     * так чтобы она выходила из стены паралельной данной
     *
     * @param width ширина игрового поля
     * @param height высота игрового поля
     */
    public void changeOfCoordinates(int width, int height) {
        Fruit current = head;
        if (current.getCoordinates().getX() == width) {
            current.getCoordinates().setX(1);
        } else if (current.getCoordinates().getX() == 0) {
            current.getCoordinates().setX(--width);
        }
        if (current.getCoordinates().getY() == height) {
            current.getCoordinates().setY(1);
        } else if (current.getCoordinates().getY() == 0) {
            current.getCoordinates().setY(--height);
        }
    }

    /**
     * метод движения змеи вправо
     */
    @Override
    public void toRight() {
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

    /**
     * метод движения змеи влево
     */
    @Override
    public void toLeft() {
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

    /**
     * метод движения змеи вверх
     */
    @Override
    public void toUp() {
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

    /**
     * метод движения змеи вниз
     */
    @Override
    public void toDown() {

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

    /**
     *
     * @return голову змеи {@link Snake}
     */
    public Fruit getHead() {
        return head;
    }
}



