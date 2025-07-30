package com.example.analysis;

import com.example.model.Student;
import java.util.*;
import java.util.stream.*;

public class StudentAnalysis {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Vimal", 28, "Male", new int[]{90, 85, 70, 65, 95}, "Chennai"),
            new Student("Kutty Vimal", 21, "Male", new int[]{75, 73, 72, 65, 80}, "Chennai"),
            new Student("Devika", 28, "Female", new int[]{78, 89, 97, 76, 95}, "Chennai")
        );

        System.out.println("========== List of all students ==========");
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("========== Student entered in 2025 ==========");
        students.stream()
                .filter(student -> student.getYearOfAdmission() == 2025)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("========== Student details whose name is Vimal ==========");
        students.stream()
                .filter(student -> student.getName().equalsIgnoreCase("vimal"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("========== Sort the students by marks ==========");
        students.stream()
                .sorted(Comparator.comparing(Student::getTotal).reversed())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("========== Topper Student ==========");
        students.stream()
                .max(Comparator.comparing(Student::getTotal))
                .ifPresent(System.out::println);
        System.out.println();

        System.out.println("========== Grouping students by gender ==========");
        students.stream()
                .collect(Collectors.groupingBy(Student::getGender))
                .forEach((gender, list) -> System.out.println(gender + " : " + list));
        System.out.println();

        System.out.println("========== Top 3 Student Details ==========");
        students.stream()
                .sorted(Comparator.comparing(Student::getTotal).reversed())
                .limit(3)
                .forEach(System.out::println);
        System.out.println();
    }
}