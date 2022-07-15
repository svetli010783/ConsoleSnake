package com.company;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("""
                1-начать игру
                2-правила игры
                3-выйти
                """);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {
            System.out.println("""
                    @ - это фрукт, когда твоя змея ест его она растет
                    ##### - так выглядит стенка когда змея бьется о нее, игра заканчивается
                    *******8 - это змея, твой игровой персонаж
                    """);
            start();
        }
        else if (choice == 3){
            return;
        }
        else {
            System.out.println("Такого действия нет");
            start();
        }
    }
}
