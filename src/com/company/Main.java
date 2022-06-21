package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    static char direction = 'd';
    static char oldDirection;
    static int width = 30;
    static int height = 14;
    static Snake snake = new Snake(width, height);
    static Menu menu = new Menu();

    public static void main(String[] args) {
        menu.start();

        Runnable helloRunnable = new Runnable() {
            public void run() {
                renderFrame();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);


        while (true) {
            Scanner input = new Scanner(System.in);
            direction = input.next().charAt(0);
        }
    }


    private static void renderFrame() {
        directionSwitching(direction);
        System.out.println("Frame Rendering");
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                Coordinate coord = new Coordinate(x, y);
                if (x == 0 || y == 0 || y == height || x == width)
                    System.out.print("#");
                else if (snake.hasCoordinate(coord))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static void directionSwitching(char direction) {
        if (direction == 'w') {
            snake.moveUp(oldDirection);
        } else if (direction == 'a') {
            snake.moveleft(oldDirection);
        } else if (direction == 's') {
            snake.moveDown(oldDirection);
        } else if (direction == 'd') {
            snake.moveRight(oldDirection);
        } else {

        }
        oldDirection = direction;

    }

}
