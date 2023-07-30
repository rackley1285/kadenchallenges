package com.kaden.oop.lesson2;

public class Lesson2 {

    //Let's do some more fun stuff with classes.
    //Say for example we want to extend the functionality of our car in some way, maybe we want to give it a bed and
    //call it a truck, how would we do that? would we need to create a whole new class that also adds the #honkHorn method?

    //Nope! We can just extend Car with new stuff! (Literally just extend)
    //Below is a common example of a class that extends another
    static class Truck extends Car {

        //Note that we have a variable here in the root of the class. We call these fields.
        //Also note that it is private, so only things within this class have access to it, that's why we added
        //"getter" and "setter" methods to this class which can, you guessed it, get and set the contents of that field.
        private String bedContents;

        //We want to have the option to put something on the trucks bed when we instantiate it so we added a parameter
        //to the constructor of this class.
        public Truck(String bedContents) {
            //Note that we used the same parameter name as the field name. this is allowed, but the compiler can only infer
            //the reference to one of the name, so we use the "this" keyword, which references any object that is instantiated
            //from 'this' class. 'this' does not refer to this CLASS, only an OBJECT instantiated from this class.
            this.bedContents = bedContents;
        }

        //We can also have a second constructor with no parameters which can default the contents of the truck to "empty"
        //Note that it calls the other constructor with a default value, this is caleld "overloading" the constructor.
        public Truck() {
            this("empty");
        }

        public String getBedContents() {
            return bedContents;
        }

        public void setBedContents(String bedContents) {
            this.bedContents = bedContents;
        }
    }

    //Let's try out our new class!
    public static void main(String[] args) {

        //Note that we can instantiate the truck with contents or none by default
        Truck truck1 = new Truck(); //An empty truck
        Truck truck2 = new Truck("Kaden's Bed"); //A truck with contents

        //Now we can get (and print) the contents of the trucks
        System.out.println(truck1.getBedContents());
        System.out.println(truck2.getBedContents());

        //Or we can change the contents of the trucks
        truck2.setBedContents("Kaden's Bed & Mattress");
        //And print the new contents
        System.out.println(truck2.getBedContents());

        //Hold up though, how about the functionality of Car, can I still use that?
        //Yes >:) we call this pass-through functionality in the Java world as "Inheritance"
        truck1.honkHorn();
        truck2.honkHorn();
    }
}
