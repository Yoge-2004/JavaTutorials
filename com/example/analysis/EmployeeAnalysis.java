package com.example.analysis;

import com.example.model.Employee;

import java.util.*;
import java.util.stream.*;
import java.time.*;

public class EmployeeAnalysis {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            Employee.addEmployee("Vimal Raj", "Java Trainer", 1000000),
            Employee.addEmployee("Vignesh", "Aptitude Trainer", 500000),
            Employee.addEmployee("Gaddiel", "Soft Skills Trainer", 5000000),
            Employee.addEmployee("Tushar Rajkumar Umbardand", "Java Trainer", 2000000),
            Employee.addEmployee("Devika", "Soft Skills Trainer", 750000)
        );

        System.out.println("=========== All Employee Details =========== ");
        employees.forEach(System.out::println);
        System.out.println();

        System.out.println("========== Employees sorted based on experience and then salary ==========");
        employees.stream()
            .sorted(Comparator.comparing(Employee::getExperience).thenComparing(Employee::getSalary))
            .forEach(System.out::println);
        System.out.println();

        System.out.println("========== Employees sorted based on name ==========");
        employees.stream()
            .sorted()
            .forEach(System.out::println);
        System.out.println();

        System.out.println("========== List of departments ==========");
        employees.stream()
            .map(Employee::getDepartment)
            .distinct()
            .forEach(System.out::println);
        System.out.println();

        System.out.println("========== Sum of all employees wages ==========");
        DoubleSummaryStatistics salaryStatistics = employees.stream()
            .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Statistics: " + salaryStatistics);
        System.out.println();

        System.out.println("========== Count the employees based on their name starting letter ==========");
        employees.stream()
            .map(e -> e.getName().charAt(0))
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
            .forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println();

        System.out.println("========== Average salary for each department ==========");
        employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
            .forEach((dept, avg) -> System.out.println(dept + " : " + avg));
        System.out.println();

        System.out.println("========== Joining all employees name ==========");
        String joinedNames = employees.stream()
            .map(Employee::getName)
            .collect(Collectors.joining(", "));
        System.out.println(joinedNames);
    }
}
