package com.example.queuedemo;

import java.util.*;

public class BasicQueueOperations {
    public static void run() {
        System.out.println("=== Basic Queue Operations ===");
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());

        System.out.println("After poll: " + queue);
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());

        queue.remove(2);
        System.out.println("After removing element 2: " + queue);
        System.out.println();
    }
}
