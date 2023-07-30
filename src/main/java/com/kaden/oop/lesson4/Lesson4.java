package com.kaden.oop.lesson4;

import com.kaden.oop.lesson2.Car;

public class Lesson4 {

    //This lesson is pretty simple, but introduces a fancy word that is important "Polymorphism". Technically
    //You have already seen what this word means, but you haven't seen an example where it matters. Let's look at a
    //Simple one.

    static class Chevy extends Car { }
    static class Honda extends Car { }
    static class Toyota extends Car { }

    public static void main(String[] args) {

        Chevy chevy = new Chevy();
        Honda honda = new Honda();
        Toyota toyota = new Toyota();

        //Polymorphism is (from the perspective of a superclass) being able to take the form of multiple things.
        //In this example Car (the superclass of Chevy, Honda, and Toyoda) is exhibiting polymorphism by taking the
        //shape of all of these subclasses, and it's functionality still being useful.
        chevy.honkHorn();
        honda.honkHorn();
        toyota.honkHorn();
    }
}
