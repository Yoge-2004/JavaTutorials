package com.example.model;

import java.time.LocalDate;
import java.util.*;

public class Student implements Comparable<Student> {
    private static int last = 0;
    private int id = 0;

    {
        id = ++last;
    }

    private String name;
    private int age;
    private String gender;
    private static String course = "Computer Science with Maths";
    private int[] marks = new int[5];
    private char[] grades = new char[5];
    private String city;
    private int yearOfAdmission = LocalDate.now().getYear();
    private int total;
    private double average;

    public Student(String name, int age, String gender, int[] marks, String city) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.marks = marks;
        this.city = city;
        this.calculateGrades(marks);
        total = Arrays.stream(marks).sum();
        average = total / 5.0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public int[] getMarks() { return marks; }
    public String getCity() { return city; }
    public char[] getGrades() { return grades; }
    public int getTotal() { return total; }
    public double getAverage() { return average; }
    public int getYearOfAdmission() { return yearOfAdmission; }
    public String getCourse() { return course; }

    private void calculateGrades(int[] marks) {
        for (int i = 0; i < 5; i++) {
            grades[i] = switch (marks[i] / 10) {
                case 10 -> 'O';
                case 9 -> 'A';
                case 8 -> 'B';
                case 7 -> 'C';
                case 6 -> 'D';
                default -> 'F';
            };
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
               name.equals(student.name) &&
               gender.equals(student.gender) &&
               city.equals(student.city) &&
               Arrays.equals(marks, student.marks) &&
               Arrays.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, course, yearOfAdmission, city);
    }

    @Override
    public int compareTo(Student student) {
        return student.name.compareToIgnoreCase(this.name);
    }

    @Override
    public String toString() {
        return "Student = {id = " + id +
                ", name = " + name +
                ", age = " + age +
                ", gender = " + gender +
                ", course = " + course +
                ", admission year = " + yearOfAdmission +
                ", marks = " + Arrays.toString(marks) +
                ", total = " + total +
                ", average = " + average +
                ", grades = " + Arrays.toString(grades) +
                ", city = " + city + "}";
    }
}