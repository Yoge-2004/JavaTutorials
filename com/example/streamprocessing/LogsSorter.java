package com.example.streamprocessing;

import java.util.*;
import java.util.stream.*;

public class LogsSorter {
    public static void main(String[] args) {
        List<ArrayList<String>> logEntries = new ArrayList<>();
        
        logEntries.addAll(Arrays.asList(
            new ArrayList<>(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed")),
            new ArrayList<>(Arrays.asList("01-01-2023", "15:00", "INFO", "established")),
            new ArrayList<>(Arrays.asList("01-01-2023", "01:30", "ERROR", "failed"))
        ));
        
        List<ArrayList<String>> filteredLogEntries = logEntries.stream()
            .filter(list -> list.get(2).equals("ERROR") || list.get(2).equals("CRITICAL"))
            .sorted(Comparator.comparing((ArrayList<String> list) -> list.get(1)))
            .toList();
        
        filteredLogEntries.forEach(System.out::println);
    }
}
