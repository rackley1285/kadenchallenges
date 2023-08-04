package com.kaden.challenges;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {

        //Print the instructions to the user
        System.out.println("""
                Hi, I'm GameFriend! Thanks for choosing NumberGuesser!
                In this game you need to think of your favorite number from 0 to 100. I'll be trying to guess it, so remember what it is!
                When I make a guess, let me know how I did by saying 'lower' if I need to guess lower, 'higher' if I need to guess higher, or 'yes' if I'm spot-on!.
                I'm sure I'll get it eventually! If you change your mind about playing you can just say 'goodbye' and we'll play some other time.
                
                Type 'go' when you have chosen your number!""");

        //initialize the input reader and the variables that pertain to that input
        Scanner input = new Scanner(System.in);
        String response;
        List<String> allowedResponses = List.of("go", "yes", "higher", "lower", "goodbye");

        //Init some variables to do with guessing
        int guess = 50;
        int numGuesses = 0;
        int min = 0;
        int max = 100;

        //A new random object to generate guesses from
        Random random = new Random();

        while (true) {

            //Record the user's input
            response = input.nextLine().toLowerCase();

            //Make sure that the user starts the game before we start guessing
            if (numGuesses == 0 && !response.equals("go")) {
                System.out.println("Sorry, I can only start if you say 'go'! I don't know many words...");
                continue;
            }

            //Validate inputs
            if (!allowedResponses.contains(response)) {
                System.out.println("Huh? I don't know what that means. Tell me if my guess needs to be 'higher' or 'lower' as simply as possible!");
                continue;
            }

            //Make sure the player isn't cheating and if they are quit the game
            if ((response.equals("higher") && guess <= min) || (response.equals("lower") && guess >= max)) {
                System.out.println("I think you're cheating! I don't want to play with a cheater!");
                break;
            }

            //Print a response to your input
            switch (response) {
                case "go" -> System.out.println(numGuesses > 0 ? "I'm already going bro" : "Alright, let me guess...");
                case "yes" -> System.out.println("Awesone! Thanks for playing, it took me " + numGuesses + " guesses to figure out your number!");
                case "goodbye" -> System.out.println("Goodbye!");
                case "higher" -> min = guess + 1;
                case "lower" -> max = guess - 1;
            }

            //Exit the game if your number was guessed or if you are a quitter.
            if (response.equals("yes") || response.equals("goodbye")) break;

            //Guess a new number
            numGuesses++;
            guess = random.nextInt(max - min) + min;

            //Ask the user about the new guess
            System.out.println("If your number " + guess + "?");
        }

        System.out.println("The game has ended");
    }
}
