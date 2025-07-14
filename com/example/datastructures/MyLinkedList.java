package com.example.datastructures;

import java.util.*;

public class MyLinkedList<T> implements Cloneable, Iterable<T> {

    private class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }

    public T add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return data;
    }

    public boolean insertAt(int index, T data) {
        if (index < 0 || index > size) return false;
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) tail = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(T data) {
        if (isEmpty()) return false;
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                if (current.next == tail) tail = current;
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int search(T key) {
        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(key)) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean isPresent(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyLinkedList<?>)) return false;
        MyLinkedList<?> other = (MyLinkedList<?>) o;
        if (this.size != other.size) return false;
        Node<T> current1 = this.head;
        MyLinkedList<?>.Node<?> current2 = other.head;
        while (current1 != null && current2 != null) {
            if (!Objects.equals(current1.data, current2.data)) return false;
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        Node<T> current = head;
        while (current != null) {
            hash = 31 * hash + (current.data == null ? 0 : current.data.hashCode());
            current = current.next;
        }
        return hash;
    }

    @Override
    public MyLinkedList<T> clone() {
        MyLinkedList<T> clone = new MyLinkedList<>();
        Node<T> current = this.head;
        while (current != null) {
            clone.add(current.data);
            current = current.next;
        }
        return clone;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private Node<T> lastReturned = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastReturned = current;
                T data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException("Call next() before remove()");
                MyLinkedList.this.remove(lastReturned.data);
                lastReturned = null;
            }
        };
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;
        tail = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        if (size <= 1) return;
        List<T> tempList = new ArrayList<>();
        for (T item : this) tempList.add(item);
        tempList.sort((a, b) -> ((Comparable<T>) a).compareTo(b));
        clear();
        for (T item : tempList) add(item);
    }
}
