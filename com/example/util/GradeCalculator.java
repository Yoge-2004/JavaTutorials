package com.example.util;

public class GradeCalculator {
    public static char calculateGrade(int... subjectMarks) {
        int total = 0;
        for (int mark : subjectMarks) {
            total += mark;
        }
        double totalPercentage = (double) total / subjectMarks.length;
        if (totalPercentage >= 90.0) {
            return 'A';
        } else if (totalPercentage >= 80.0) {
            return 'B';
        } else if (totalPercentage >= 70.0) {
            return 'C';
        } else if (totalPercentage >= 60.0) {
            return 'D';
        } else if (totalPercentage >= 40.0) {
            return 'E';
        } else {
            return 'F';
        }
    }
}
