package com.epam.se02.inner;

import java.util.Iterator;

public class Example2 {

    public static void main(String[] args) {
        List<String> list = new LinearList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        System.out.println("Iterator: ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Foreach: ");
        for (String element : list) {
            System.out.println(element);
        }

        System.out.println("ForEach: ");
        list.forEach(System.out::println);
    }
}

interface List<E> extends Iterable<E> {

    void add(E element);

    E removeFirst();

    E get(int index);

    int size();
}

class LinearList<E> implements List<E> {

    private Node<E> head;

    @Override
    public Iterator<E> iterator() {
        return new LinearListIterator(head);
    }

    private class LinearListIterator implements Iterator<E> {

        private Node<E> curr;

        public LinearListIterator(Node<E> curr) {
            this.curr = curr;
        }

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