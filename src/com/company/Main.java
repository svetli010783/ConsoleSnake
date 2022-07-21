package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    static char direction = 'd';
    static char oldDirection = 'd';
    public static int width = 30;
    public static int height = 14;
    static Snake snake = new Snake(width, height);
    static boolean hasFruit = false;
    static Fruit eat = null;
    static boolean isEnd;
    static int score;


    public static void main(String[] args) {

        Runnable helloRunnable = new Runnable() {
            public void run() {
                createFruit();
                eat();
                end();
                renderFrame();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 750, TimeUnit.MILLISECONDS);


        while (true) {
            Scanner input = new Scanner(System.in);
            direction = input.next().charAt(0);
        }


    }

    /**
     * данный метод выыодит очки игрока и  останавливает работу программы ,
     * в тот момент когда змейка врезается в саму себя
     */
    public static void end() {
        if (isEnd) {
            System.out.println("Вы проиграли");
            System.out.println("Ваш счет " + score);
            System.exit(1);
        }
    }

    /**
     * этот метод вызывает метод увеличения размера змеи,
     * когда координаты головы змеи становятся равны координатам фрукта и
     * добавляет 100 к счетчику очков
     */
    public static void eat() {
        if (eat.getCoordinates().equals(snake.getHead().getCoordinates())) {
            snake.eat(eat);
            hasFruit = false;
            score = score + 100;
        }
    }

    /**
     * метод который создает фрукт с рандомными координатами,
     * в тот момент когда старый фрукт съедает змея
     */
    public static void createFruit() {
        while (!hasFruit) {
            eat = new Fruit(
                    new Coordinate(
                            (int) (Math.random() * width),
                            (int) (Math.random() * height)
                    ),
                    null,
                    null);
            hasFruit = true;
        }
    }

    /**
     * метод кторый осуществляет отрисовку кадров
     */
    private static void renderFrame() {
        clrscr();
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                Coordinate coord = new Coordinate(x, y);
                eat.changeOfCoordinates(width, height);
                snake.changeOfCoordinates(width, height);
                if (snake.isDeath(eat)) {
                    isEnd = true;
                }
                if (y == 0 || y == height)
                    System.out.print("_");
                else if (x == 0 || x == width) {
                    System.out.print("|");
                } else if (snake.hasCoordinate(coord))
                    System.out.print("*");
                else if (eat.hasCoordinate(coord)) {
                    System.out.print("@");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
        directionSwitching(direction);
    }

    /**
     * метод изменнения направления змеи на то которое было указано в direction
     * @param direction этот параметр описывает направление змейки
     */
    private static void directionSwitching(char direction) {
        if (direction == 'w' && oldDirection != 's') {
            snake.toUp();
            oldDirection = direction;
        } else if (direction == 'a' && oldDirection != 'd') {
            snake.toLeft();
            oldDirection = direction;
        } else if (direction == 's' && oldDirection != 'w') {
            snake.toDown();
            oldDirection = direction;
        } else if (direction == 'd' && oldDirection != 'a') {
            snake.toRight();
            oldDirection = direction;
        } else {
            direction = oldDirection;
            directionSwitching(direction);
        }

    }

    /**
     * метод очистки командной строки
     */
    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}