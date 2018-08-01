package com.epam.se02.inner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Example3 {

    private Map<String, Integer> map = new HashMap<String, Integer>() {{
        put("1", 1);
        put("2", 2);
        put("3", 3);
    }};

    private java.util.List<String> list = Arrays.asList("1", "1", "2");

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);


    }
}

class LinearListWithAnonymousIterator<E> implements List<E> {

    private Node<E> head;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> curr;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E result = curr.element;
                curr = curr.next;
                return result;
            }
        };
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        private Node(T element) {
            this.element = element;
        }
    }

    @Override
    public void add(E element) {
        Node<E> tail = new Node<>(element);
        if (head == null) {
            head = tail;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = tail;
        }
    }

    @Override
    public E removeFirst() {
        Node<E> oldHead = this.head;
        if (oldHead == null) {
            throw new IllegalStateException();
        }
        head = head.next;
        return oldHead.element;
    }

    @Override
    public E get(int index) {
        Node<E> curr = head;
        if (curr == null) {
            throw new IndexOutOfBoundsException();
        }
        for (int currIndex = 0; currIndex < index; ++currIndex) {
            if (curr == null) {
                throw new IndexOutOfBoundsException();
            }
            curr = curr.next;
        }
        return curr.element;
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> curr = head;
        while (curr != null) {
            curr = curr.next;
            ++size;
        }
        return size;
    }
}