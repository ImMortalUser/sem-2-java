package ru.vsu.cs.cource1;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /*
        System.out.print("Введите положение коня: ");
        Scanner scanner = new Scanner(System.in);
        int x, y, xf, yf;
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.print("Введите необходимую клетку: ");
        xf = scanner.nextInt();
        yf = scanner.nextInt();
        */
        Random random = new Random();
        int max = 0;
        for (int i = 0; i < 100000; i++) {
            UtilsFinal u = new UtilsFinal(random.nextInt(8), random.nextInt(8), random.nextInt(8), random.nextInt(8));
            u.start();
            if (u.moves > max)
                max = u.moves;
            System.out.println("##########");
        }
        System.out.println(max+ " : max");
    }
}
