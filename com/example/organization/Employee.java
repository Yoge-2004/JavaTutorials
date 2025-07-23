package com.example.organization;

public class Employee implements Comparable<Employee> {
    private static int autoIncrementValue = 0;

    {
        id = ++autoIncrementValue;
    }

    private int id;
    private String name;
    private int projectId;
    private String designation;
    private String mobileNumber;
    double salary;

    public Employee(String name, int projectId, String designation, String mobileNumber, double salary) {
        this.name = name;
        this.projectId = projectId;
        this.designation = designation;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getProjectId() { return this.projectId; }
    public String getDesignation() { return this.designation; }
    public String getMobileNumber() { return this.mobileNumber; }
    public double getSalary() { return this.salary; }

    @Override
    public String toString() {
        return "Employee [id = " + this.getId() +
               ", name = " + this.getName() +
               ", project id = " + this.getProjectId() +
               ", designation = " + this.getDesignation() +
               ", mobile = " + this.getMobileNumber() +
               ", salary = " + this.getSalary() + "]";
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.id == employee.id) return this.name.compareToIgnoreCase(employee.name);
        return this.id - employee.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return employee.id == this.id && employee.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return id * 31 + name.hashCode();
    }
}
