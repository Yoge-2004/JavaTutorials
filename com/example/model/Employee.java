package com.example.model;

import java.time.*;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private static int increment = 1;
    private static int counter = 0;
    private int id;
    private LocalDateTime joinedDate = LocalDateTime.now();
    private String name;
    private String department;
    private int experience;
    private double salary;

    {
        counter += increment;
        id = counter;
        Period period = Period.between(joinedDate.toLocalDate(), LocalDate.now());
        experience = period.getYears();
    }

    private Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static Employee addEmployee(String name, String department, double salary) {
        return new Employee(name, department, salary);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public LocalDateTime getJoinedDate() { return joinedDate; }

    @Override
    public int compareTo(Employee emp) {
        return this.name.compareToIgnoreCase(emp.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Employee emp = (Employee) o;
        return id == emp.id && name.equalsIgnoreCase(emp.name) &&
                joinedDate.equals(emp.joinedDate) &&
                salary == emp.salary &&
                department.equalsIgnoreCase(emp.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, joinedDate, salary, department);
    }

    @Override
    public String toString() {
        return "Employee = {id = " + id +
                ", name = " + name +
                ", joined date = " + joinedDate +
                ", salary = " + salary +
                ", department = " + department +
                ", experience = " + experience + "}";
    }
}
