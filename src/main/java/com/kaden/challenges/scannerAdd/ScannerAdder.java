package com.kaden.challenges.scannerAdd;

import java.util.Scanner;

public class ScannerAdder {


    public static void main(String[] args) {



        Scanner adder = new Scanner(System.in);

        System.out.println("What is the first number you would like to add?");
        int number1 = adder.nextInt();

        System.out.println("Thanks! What is the second number you would like to add?");
        int number2 = adder.nextInt();

        int sum = number1 + number2;

        System.out.println("Thanks again! The sum of " + number1 + " and " + number2 + " is " + sum + ". Goodbye!");

    }
}
