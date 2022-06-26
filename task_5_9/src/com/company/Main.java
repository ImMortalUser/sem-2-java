package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        /** Основная функция - getWanted */
        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>(Integer::parseInt);
        tree.fromBracketNotation("8 (6 (4 (5), 6), 5 (, 5 (2, 8)))");

        List<Integer> list = new ArrayList();

        list = tree.getWanted();

        int max = -1;
        for (int i = 0 ; i < list.size(); i ++) {
            if (list.get(i) > max)
                max = list.get(i);
        }

        System.out.println("max nodes = " + max);
        System.out.print("Levels: ");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max)
                System.out.print(i + " ");
        }
    }
}
