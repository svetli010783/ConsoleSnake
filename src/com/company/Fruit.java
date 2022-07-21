package com.company;

public class Fruit {
    private Coordinate coordinates;
    private Fruit previous;
    private Fruit next;

    /**
     * метод проверки наличия фрукта в точке переданных координат
     * @param coordinate координаты игрового поля
     * @return резулт проверки
     */
    public boolean hasCoordinate(Coordinate coordinate) {
        return this.getCoordinates().equals(coordinate);
    }
    /**
     * метод изменения координат фрукта при его появлении в стене
     * @param width ширина
     * @param height высота
     */
    public void changeOfCoordinates(int width, int height) {
        if (this.getCoordinates().getX() == width) {
            this.getCoordinates().setX(1);
        } else if (this.getCoordinates().getX() == 0) {
            this.getCoordinates().setX(--width);
        }
        if (this.getCoordinates().getY() == height) {
            this.getCoordinates().setY(1);
        } else if (this.getCoordinates().getY() == 0) {
            this.getCoordinates().setY(--height);
        }
    }

    /**
     *
     * @param coordinates координаты
     * @param previous предыдущий {@link Fruit}
     * @param next следующий {@link Fruit}
     */
    public Fruit(Coordinate coordinates, Fruit previous, Fruit next) {
        this.coordinates = coordinates;
        this.previous = previous;
        this.next = next;
    }

    /**
     * @return координаты фрукта
     */
    public Coordinate getCoordinates() {
        return coordinates;
    }

    /**
     * @param x координата Х
     * @param y координата У
     */
    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

    /**
     * @return предыдущий фрукт
     */
    public Fruit getPrevious() {
        return previous;
    }

    /**
     * @param previous предыдущий {@link Fruit}.
     */
    public void setPrevious(Fruit previous) {
        this.previous = previous;
    }

    /**
     * @param next следующий {@link Fruit}.
     */
    public void setNext(Fruit next) {
        this.next = next;
    }
}
