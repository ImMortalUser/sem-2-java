package ru.vsu.cs.cource1;

public class Main {

    public static void main(String[] args) throws Exception {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.read("test.txt");
        list.removeK(15);
        list.getMaxWords();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        for (int i = 0 ; i < list.size(); i ++) {
            System.out.print(list.get(i) + " ");
        }
        list.removeK(2);
        System.out.println();
        for (int i = 0 ; i < list.size(); i ++) {
            System.out.print(list.get(i)+ " ");
        }
    }
}
