package com.example.organization;

import java.util.Arrays;

public class Project {
    private static int autoIncrementValue = 0;

    private int id;
    private String projectName;
    private int[] employeeIds;

    {
        id = ++autoIncrementValue;
    }

    public Project(String projectName, int[] employeeIds) {
        this.projectName = projectName;
        this.employeeIds = employeeIds;
    }

    public int getId() { return this.id; }
    public String getName() { return this.projectName; }
    public String getEmployeeIds() { return Arrays.toString(this.employeeIds); }

    @Override
    public String toString() {
        return "Project [id = " + this.getId() +
               ", name = " + this.getName() +
               ", employee ids = " + this.getEmployeeIds() + "]";
    }
}
