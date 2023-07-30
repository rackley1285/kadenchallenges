package com.kaden.oop.lesson1;

public class Lesson1 {

    //First lets understand what a class is and what an object is
    //Define a class with the class keyword and open and closed braces
    //This class has to be static since it's an "inner class" (A class defined within another class, usually don't do this)
    static class Car {

        //Define a constructor so that this class can be instantiated with the 'new' keyword later
        public Car() {

        }

        //Define a method on this class that can be called on an object of this class
        public void honkHorn() {
            System.out.println("Beep Beep");
        }

    }

    //Above defines a very basic class. Now what is it useful for?
    public static void main(String[] args) {

        //Let's create an instance of a car
        Car car = new Car();

        //Now that we have an instance of a car we can do things with it, like call methods that exist on that class.
        car.honkHorn();

        //This is how classes are used! (in the most basic form) They can also store some data, we will look at that later
    }

}
