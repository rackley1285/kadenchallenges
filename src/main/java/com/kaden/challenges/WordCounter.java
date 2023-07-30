package com.kaden.challenges;

import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {

        Scanner countWords = new Scanner(System.in);

        System.out.println("Hello! If you type some text I can tell you how many words you typed!");
        String input = countWords.nextLine();

        String[] words = input.split(" ");

        System.out.println("You typed " + words.length + " words!");

    }
}
