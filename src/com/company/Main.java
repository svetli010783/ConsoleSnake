package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Main {
    static char direction = 'd';
    static char oldDirection = 'd';
    public static int width = 30;
    public static int height = 14;
    static Snake snake = new Snake(width, height);
    static Menu menu = new Menu();
    static boolean hasFruit = false;
    static Fruit eat = null;
    static boolean isEnd;
    static int score;
    static Consumer<ExecutorService> shutdown = ExecutorService::shutdown;


    public static void main(String[] args) {
        menu.start();

        Runnable helloRunnable = new Runnable() {
            public void run() {
                if (isEnd){
                    System.out.println("Вы проиграли");
                    System.out.println("Ваш счет " + score);
                    System.exit(1);
                }
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


    private static void renderFrame() {
        clrscr();
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
        if (eat.getCoordinates().equals(snake.getHead().getCoordinates())) {
            var copy = snake.eat(eat, hasFruit);
            hasFruit = copy;
            score = score + 100;
        }


        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                Coordinate coord = new Coordinate(x, y);
                eat.changeOfCoordinates(width, height);
                snake.changeOfCoordinates(width, height);
                if (snake.death(eat)) {
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

    private static void directionSwitching(char direction) {
        if (direction == 'w' && oldDirection != 's') {
            snake.moveUp();
            oldDirection = direction;
        } else if (direction == 'a' && oldDirection != 'd') {
            snake.moveleft();
            oldDirection = direction;
        } else if (direction == 's' && oldDirection != 'w') {
            snake.moveDown();
            oldDirection = direction;
        } else if (direction == 'd' && oldDirection != 'a') {
            snake.moveRight();
            oldDirection = direction;
        } else {
            direction = oldDirection;
            directionSwitching(direction);
        }

    }

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