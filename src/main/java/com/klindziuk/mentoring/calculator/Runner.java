package com.klindziuk.mentoring.calculator;

/**
 * Created by Hp on 28/10/2017.
 */
public class Runner {

    public static void main(String[] args) {
      Float result =  CommandLineCalculator.calculate(args);
      System.out.println(result);
    }
}
