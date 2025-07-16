package com.example.datastructures;
import java.util.*;

class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original: " + stack);

        MyStack<Integer> cloned = stack.clone();
        System.out.println("Cloned:   " + cloned);

        System.out.println("Equal? " + stack.equals(cloned));

    }
}

class MyStack<T extends Comparable<T>> implements Comparable<MyStack<T>>, Cloneable, Iterable<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private int size;
    private Node<T> top;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
        return data;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyStack<?> other)) return false;

        Node<T> current1 = this.top;
        Node<?> current2 = other.top;

        while (current1 != null && current2 != null) {
            if (!current1.data.equals(current2.data)) return false;
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    @Override
    public int compareTo(MyStack<T> other) {
        if (this.size > other.size) return 1;
        if (this.size < other.size) return -1;
        return this.equals(other) ? 0 : 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public MyStack<T> clone() {
        MyStack<T> newStack = new MyStack<>();
        List<T> elements = new ArrayList<>();

        for (Node<T> current = top; current != null; current = current.next) {
            elements.add(current.data);
        }

        for (int i = elements.size() - 1; i >= 0; i--) {
            newStack.push(elements.get(i));
        }

        return newStack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
