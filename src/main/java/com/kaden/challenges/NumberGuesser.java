package com.kaden.challenges;


import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {

        System.out.println("""
                Hi, I'm GameFriend! Thanks for choosing NumberGuesser!
                In this game you need to think of your favorite number from 0 to 100. I'll be trying to guess it, so remember what it is!
                When I make a guess, let me know how I did by saying 'lower' if I need to guess lower, 'higher' if I need to guess higher, or 'yes' if I'm spot-on!.
                I'm sure I'll get it eventually! If you change your mind about playing you can just say 'goodbye' and we'll play some other time.
                
                Type 'go' when you have chosen your number!""");

        Scanner input = new Scanner(System.in);
        String response = input.nextLine().toLowerCase();

        int lastGuess = 101;
        int guess;
        int floor = 0;
        int ceiling = 100;
        boolean end = false;

        while (!end) {

            if (response.equals("go")) {
                System.out.println("Great!");

                do {

                    int range = ceiling - floor;

                    guess = (int) Math.round(Math.random() * range / 2) + floor + range / 4;
                    if (guess == lastGuess) {
                        guess++;
                    }
                    System.out.println("Is your number " + guess + "?");
                    response = input.nextLine().toLowerCase();

                    if ((response.equals("lower") && guess == floor) || (response.equals("higher") && guess == ceiling)) {
                        System.out.println("I think you're cheating! I don't want to play with a cheater!");
                        end = true;

                    } else {
                        switch (response) {
                            case "yes" -> {
                                System.out.println("Awesome! Thanks for playing!");
                                end = true;
                            }
                            case "goodbye" -> end = true;
                            case "higher" -> {
                                lastGuess = guess;
                                floor = guess;
                            }
                            case "lower" -> {
                                lastGuess = guess;
                                ceiling = guess - 1;
                            }
                            default -> System.out.println("Huh? I don't know what that means. Tell me if my guess needs to be 'higher' or 'lower' as simply as possible!");

                        }

                    }

                } while (!end);

            } else if (response.equals("goodbye")) {
                end = true;

            } else {
                    System.out.println("Sorry, I can only start if you say 'go'! I don't know many words...");
                    response = input.nextLine().toLowerCase();
            }
        }
        System.out.println("Goodbye!");
    }


}
