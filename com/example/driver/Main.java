package com.example.driver;

import com.example.logic.ComplexNumber;

public class Main { 
  public static void main(String[] args) { 
    ComplexNumber number1 = new ComplexNumber(1, 3); 
    ComplexNumber number2 = new ComplexNumber(3, 1); 
    number1.add(number2); 
  } 
}
