package com.example.arrayutils;

import java.util.*;
import java.util.stream.*;

public class IncrementArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int number = Arrays.stream(arr)
             .boxed()
             .reduce((a, b) -> a * 10 + b)
             .orElse(0);

        int[] result = String.valueOf(++number)
                .chars()
                .map(i -> i - '0')
                .toArray();

        System.out.println(Arrays.toString(result));
    }
}
