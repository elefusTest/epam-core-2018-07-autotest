package com.epam.se11;

public interface Stack<E> {

    void push(E element);

    E pop() throws IllegalStateException;

    boolean isEmpty();

    int size();
}
