package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;

public class Main {

    public static void generateRandomList(List<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
            System.out.println("Place = " + i + " " + list.get(i));
        }
    }

    public static void main(String[] args) {
        int num = 5;
        int amountOfElements = 100;
        List<Integer> l = new ArrayList();
        //Map<Integer, List<Integer>> map = new HashMap<>();
        SimpleHashMap<Integer,List<Integer>> map = new SimpleHashMap<>(amountOfElements);
        /** n - количество элементов */
        generateRandomList(l, amountOfElements);
        int max = -1;
        num = -1;
        /** Создание map и присвоение списка индексов для каждого значения из списка l */

        for (int i = 0; i < l.size(); i++) {
            List<Integer> list = new ArrayList();
            num = l.get(i);
            if (map.get(num) == null) {
                list.add(i);
                map.put(num, list);
            } else {
                list = map.get(num);
                list.add(i);
                map.put(num, list);
            }
        }

        for (int i = 0; i < l.size(); i++) {
            int c = map.get(l.get(i)).size();
            if (c > max) {
                max = c;
                num = l.get(i);
            }
            else if (c == max) {
                if (l.get(i) > num)
                    num = l.get(i);
            }
        }
        System.out.println();
        System.out.println("Число " + num + " встречается " + max + " раз(а)");

        List list = map.get(num);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }

    }
}

