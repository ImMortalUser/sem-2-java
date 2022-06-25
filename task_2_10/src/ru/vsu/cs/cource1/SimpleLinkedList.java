package ru.vsu.cs.cource1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleLinkedList<T> implements Iterable<T> {

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;  // first, top
    private SimpleLinkedListNode tail = null;  // last
    private int size = 0;

    public void read(String s) {
        try (FileReader reader = new FileReader(s)) {
            String word = "";
            int c;
            while ((c = reader.read()) != -1) {
                if ((char) c != ' ') {
                    word += (char) c;
                } else {
                    this.addFirst((T) word);
                    word = "";
                }
            }
            this.addFirst((T) word);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void getMaxWords() {
        SimpleLinkedList<String> listMax = new SimpleLinkedList<>();
        int max = 0;
        String word;
        for (int i = 0; i < this.size(); i++) {
            word = this.getNode(i).value.toString();
            if (word.length() > max) {
                listMax = new SimpleLinkedList<>();
                max = word.length();
                listMax.addFirst(word);
            } else if (word.length() == max) {
                listMax.addFirst(word);
            }
        }
        for (int i = 0; i < listMax.size; i++) {
            System.out.println(listMax.getNode(i).value);
        }
    }

    // O(1)
    public void addFirst(T value) {
        head = new SimpleLinkedListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // O(1)
    public void addLast(T value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    // O(n)
    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // O(1)
    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    // O(n)
    public void removeLast() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }


    public void clear() throws SimpleLinkedListException {
        checkEmptyError();
        while (size > 0) {
            removeFirst();
        }
    }

    // O(n)
    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(n)
    public T get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    // O(1)
    public T getFirst() throws SimpleLinkedListException {
        checkEmptyError();
        return head.value;
    }

    // O(1)
    public T getLast() throws SimpleLinkedListException {
        checkEmptyError();
        return tail.value;
    }


    public void removeK(int k) {
        if (k < 1) {
            System.out.println("Неверное k");
        } else if (size == 0) {
            System.out.println("Список пуст");
        } else if (size <= k) {
            head = null;
            tail = null;
            size = 0;
        } else {
            SimpleLinkedListNode cur = head;
            for (int i = size; i>size-k-1; i--) {
                cur = cur.next;
            }
            tail = cur.next;
            cur.next = null;
            size-=k;
        }
    }


    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }
}
