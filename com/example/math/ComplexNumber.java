package com.example.logic;

public class ComplexNumber { 
  private int realPart; 
  private int imaginaryPart;
  public ComplexNumber(int realPart) {
    this.realPart = realPart;
    this.imaginaryPart = 0;
  }
  
  public ComplexNumber(int realPart, int imaginaryPart) {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }

  public void add(ComplexNumber otherComplex) {
    int sumReal = this.realPart + otherComplex.realPart;
    int sumImaginary = this.imaginaryPart + otherComplex.imaginaryPart;
    System.out.println(sumReal + " + " + sumImaginary + "i");
  }
}

