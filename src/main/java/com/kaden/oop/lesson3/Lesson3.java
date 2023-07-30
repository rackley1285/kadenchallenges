package com.kaden.oop.lesson3;

import com.kaden.oop.lesson2.Car;

public class Lesson3 {

    //Let's look at our truck class again from lesson 2
    //What if we don't think that trucks' horns should sound like "beep beep" trucks are more like "honk honk" right?
    static class Truck extends Car {

        private String bedContents;

        /**
         * @param bedContents defines the contents of this truck bed
         */
        public Truck(String bedContents) {
            this.bedContents = bedContents;
        }

        public Truck() {
            this("empty");
        }

        public String getBedContents() {
            return bedContents;
        }

        public void setBedContents(String bedContents) {
            this.bedContents = bedContents;
        }

        //No Problem! You can Override methods from the extended or "super" class
        //@Override is an annotation which tells the compiler that this method isn't new, it's actually a modification
        @Override
        public void honkHorn() {
            //Note the 'super' keyword. In Java the class that you are extending is caleld the 'superclass' (Car) and the
            //Class that extended the superclass is caleld the 'subclass' (Truck).

            //super is a lot like the 'this' keyword, because it technically is referring to an instance of this class,
            //BUT it is referencing some functionality not initially specified in this class, but the superclass, so
            //the authors of java made this clarification for readability.

            //The honkHorn method currently does the exact same thing as the super class's honkHorn method since it's
            //delegating the functionality of this method to the super method with the super.honkHorn() call.

            //To change the functionality of the #honkHorn method simply remove the super delegation and replace it with
            //some new functionality
            //super.honkHorn();
            System.out.println("honk honk");
        }
    }
}
