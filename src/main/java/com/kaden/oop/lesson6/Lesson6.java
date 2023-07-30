package com.kaden.oop.lesson6;

public class Lesson6 {

    /*
    Let's talk about an even more complicated example where there are multiple levels of inheritance, and where
    using typical inheritance starts to become an issue.

    The car example is probably the most easy to grasp example as to when this issue happens

    Say you want to set up a data structure that accurately represents a variety of cars, trucks, SUVs and also
    is able to be specific per brand of vehicle.

    Your first inclination may be to create a 'Vehicle' class and based on the previous examples make a set of
    'Truck' 'Car' and 'SUV' classes that extend that and implement some functionality.

    but what happens if there is some functionality specific to a Toyoda truck or a chevy truck? do you have to create
    a ChevyTruck class a ToyodaTruck class too? You can see that this would get complicated and messy very quickly with
    very volatile inheritance structures that make it hard to make changes later, especially when there are multiple
    in each class type.

    This is where interfaces come in.
    An interface is like a contract between classes that supply similar functionality like a Truck does to a vehicle,
    let's look at that example
     */

    public static abstract class Vehicle {

        public Vehicle() {

        }

        //This is another concept that I didn't talk about yet, in abstract classes you can define some methods that are
        //required to be implemented on the subclass but have no functionality in the superclass, like the horn, so I
        //will define it like this and implement it later
        abstract void honkHorn();
    }

    public static class Chevrolet extends Vehicle {

        //As you can see I implement the honkHorn method here from the Vehicle class
        @Override
        void honkHorn() {
            System.out.println("Honk honk!");
        }
    }

    //Now lets define some functionality of a truck in an interface
    public static interface Truck {

        //Here you can see that all methods by default are implicitly abstract, without even stating that
        //Interfaces suggest that functionality will exist, but don't usually define any themselves
        void doTruckStuff();

        //There are of course exceptions to this rule, so you can define 'default' behavior
        default void useExtraGas() {
            System.out.println("Glug glug");
        }
    }

    //And another possible thing
    public static interface Hybrid {

        void regeneratePowerFromBraking();
    }

    //Now we can define some trucks!
    public static class Silverado extends Chevrolet implements Truck {

        //Note that any functionality defined on the Truck interface MUST be implemented on this class, but
        //Default methods don't need to be overriden unless we want to.
        @Override
        public void doTruckStuff() {
            //...
        }
    }

    //Another cool thing that interfaces let you do is implement as many as you want! you can only extend one class,
    //but you can implement infinite (technically)
    public static class Colorado extends Chevrolet implements Truck, Hybrid {

        @Override
        public void doTruckStuff() {
            //...
        }

        @Override
        public void regeneratePowerFromBraking() {
            //...
        }
    }

    //Also note that casting works exactly the same as with superclasses
    public static void main(String[] args) {

        Silverado silverado = new Silverado();
        Colorado colorado = new Colorado();

        silverado.useExtraGas();
        silverado.doTruckStuff();
        colorado.useExtraGas();
        colorado.doTruckStuff();
        colorado.regeneratePowerFromBraking();

        System.out.println(silverado instanceof Truck);     //True
        System.out.println(silverado instanceof Hybrid);    //False
        System.out.println(silverado instanceof Chevrolet); //True
        System.out.println(colorado instanceof Truck);      //True
        System.out.println(colorado instanceof Hybrid);     //True
        System.out.println(silverado instanceof Chevrolet); //True
    }
}
