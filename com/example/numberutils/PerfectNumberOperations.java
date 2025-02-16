package com.example.numberutils;

import java.util.ArrayList;

public class PerfectNumberOperations {
    public static ArrayList<Integer> findPerfectNumbers(int start, int end) {
        ArrayList<Integer> perfectNumbers = new ArrayList<>();
        
        for (int i = start; i <= end; i++) {
            int factorSum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    factorSum += j;
                }
            }
            if (factorSum == i) {
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }
}
