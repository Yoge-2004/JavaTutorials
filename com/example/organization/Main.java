package com.example.organization;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SortedMap<Employee, Project> map = new TreeMap<>();

        map.put(new Employee("AAA", 1, "Software Engineer", "1234******", 100000.00),
                new Project("ABC", new int[]{1, 2}));
        map.put(new Employee("BBB", 1, "Software Tester", "3456******", 75000.00),
                map.get(map.firstKey()));

        map.forEach((key, value) -> System.out.println(key + "\n" + value + "\n"));
    }
}
