package com.example.listdemo;

import java.util.Comparator;

public class DigitSumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        int sum1 = String.valueOf(num1).chars().map(ch -> ch - '0').sum();
        int sum2 = String.valueOf(num2).chars().map(ch -> ch - '0').sum();
        return sum1 - sum2;
    }
}