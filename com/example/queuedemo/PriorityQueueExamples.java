package com.example.demo;

import java.util.*;

public class PriorityQueueExamples {
    public static void runBasicPriorityQueue() {
        System.out.println("=== PriorityQueue (Max-Heap) Example ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("PriorityQueue (unsorted view): " + pq);
        System.out.println("Peek: " + pq.peek());

        pq.remove(20);
        System.out.println("After removing 20: " + pq);

        System.out.println("Polling all elements:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println("\n");
    }

    public static void runCustomPriorityQueue() {
        System.out.println("=== Custom Object PriorityQueue Example ===");

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

        taskQueue.offer(new Task("Write report", 3));
        taskQueue.offer(new Task("Fix bugs", 1));
        taskQueue.offer(new Task("Update docs", 2));

        System.out.println("Tasks in queue order (unsorted):");
        taskQueue.forEach(System.out::println);

        System.out.println("Polling tasks by priority:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

        System.out.println();
    }
}
