package com.kaden.challenges;

import java.util.Objects;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {

        System.out.println("Thanks for playing NumberGuesser! Pick your favorite number from 0 to 100 and remember it. I will give you my best guess and you tell me 'yes' I'm right! If I'm wrong, tell me I'm too high by typing 'high' or too low by typing 'low'. I'm sure I'll get it eventually! Type 'go' when you have chosen your number!");

        Scanner feedback = new Scanner(System.in);
        double firstGuess = (double)Math.round(Math.random()*100)/100;
        int guess = (int) (firstGuess * 100);

        if (Objects.equals(feedback.nextLine(), "go")) System.out.println("Great! Is your number " + guess + "?");

        int floor = 0;
        int ceiling = 100;

        String isRight = feedback.nextLine();

        while (!Objects.equals(isRight, "yes")){

            switch (isRight){
                case "low" -> floor = guess;
                case "high" -> ceiling = guess;
            };

            guess = floor + (ceiling - floor) / 2;
            System.out.println("Is your number " + guess + "?");

            isRight = feedback.nextLine();

        }

        System.out.println("Awesome! Thanks for playing!");




}

}
