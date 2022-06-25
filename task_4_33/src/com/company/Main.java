package com.company;

public class Main {

    public static void main(String[] args) {
        String[] string =
                {
                        "green", "blue", "red","yellow"
                };
        int[] arr =
                {
                        5,8,1,0
                };
        Utils.sort(string,arr);
        for (String s : string) {
            System.out.println(s);
        }
        for (int s : arr) {
            System.out.println(s);
        }
    }
}
