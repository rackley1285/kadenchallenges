package com.kaden.challenges;

import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter some text and I will reverse it for you!");
        String forward = input.nextLine();

        String backward = new StringBuilder(forward).reverse().toString();

        System.out.println("Here's the backward version. !ti evol uoy epoH");
        System.out.println(backward);

    }
}
