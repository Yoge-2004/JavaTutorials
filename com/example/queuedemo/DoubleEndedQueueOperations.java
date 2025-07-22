package com.example.queuedemo;

import java.util.*;

public class DoubleEndedQueueOperations {
    public static void run() {
        System.out.println("=== Double-Ended Queue Operations ===");
        Deque<String> deque = new ArrayDeque<>();

        deque.addFirst("Middle");
        deque.addLast("End");
        deque.offerFirst("Start");

        System.out.println("Deque: " + deque);
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removing first and last: " + deque);
        System.out.println("Contains 'Middle': " + deque.contains("Middle"));
        System.out.println();
    }
}
