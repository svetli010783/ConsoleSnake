package com.company;

public class Coordinate implements Moveble {
    private int x;
    private int y;

    /**
     * @param x координата Х
     * @param y координата У
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return строку с координатами
     */
    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * @return координату Х
     */
    public int getX() {
        return x;
    }

    /**
     * @return координату У
     */
    public int getY() {
        return y;
    }

    /**
     * метод задания координаты Х
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * метод задания координаты У
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * метод смещения координаты Х вправо
     */
    @Override
    public void toRight() {
        this.x++;
    }

    /**
     * метод смещения координаты Х влево
     */
    @Override
    public void toLeft() {
        this.x--;
    }
    /**
     * метод смещения координаты У вверх
     */
    @Override
    public void toUp() {
        this.y--;
    }
    /**
     * метод смещения координаты У внизи
     */
    @Override
    public void toDown() {
        this.y++;
    }

    /**
     * метод проверки координат на равенство
     * @param o
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }
}
