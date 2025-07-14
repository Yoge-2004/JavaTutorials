package com.example.datastructures;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        System.out.println("Original: " + list);
        list.sort();
        System.out.println("Sorted: " + list);
        list.reverse();
        System.out.println("Reversed: " + list);
        list.clear();
        System.out.println("Cleared: " + list);
    }
}
