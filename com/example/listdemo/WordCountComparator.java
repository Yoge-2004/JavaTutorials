package com.example.listdemo;

import java.util.Comparator;

public class WordCountComparator implements Comparator<String> {
    @Override
    public int compare(String sentence1, String sentence2) {
        int count1 = sentence1.split("\\s+").length;
        int count2 = sentence2.split("\\s+").length;
        return count1 - count2;
    }
}