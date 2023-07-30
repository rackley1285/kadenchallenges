package com.kaden.oop.lesson5;

import java.util.Arrays;

public class Lesson5 {

    //Now let's get into a bit of a more complicated example.
    //Say we wanted to have many types of enemy in a game. like a Zombie, Skeleton, and Ghast.
    //The only thing that these 3 enemies have in common is that they have health, and that they are hostile.
    //So you would think that creating a class that stores some health that all of these enemies could extend, which
    //is correct, BUT in no case would you want to be able to instantiate an "Enemy" because alone it's just something
    //with health. The actual behaviours are defined on the subclasses themselves. This is where "abstract" classes
    //become useful. It's a class that has some functionality, but that can't be instantiated, only extended.

    public static abstract class Enemy {

        int health;

        //Not all enemies have the same health, so we will want to set this in the constructor
        public Enemy(int health) {
            this.health = health;
        }

        public int getHealth() {
            return health;
        }
    }

    public static class Zombie extends Enemy {

        //When you extend an abstract class you are required to have a constructor with the 'super' keyword that overloads
        //one of the constructors within the superclass (in this case we only have one to overload)
        public Zombie(int health) {
            super(health);
        }

        public void growl() {
            System.out.println("aurgh");
        }
    }

    public static class Skeleton extends Enemy {

        //Just because we have to overload the constructor doesn't mean we have to keep the parameters the same in our
        //constructor. if all skeletons will start with the same health there is no reason to request that info in the
        //constructor, so let's just pass the default health to the overloaded method (super)
        public Skeleton() {
            super(10);
        }
    }

    public static class Ghast extends Enemy {

        public Ghast() {
            super(20);
        }
    }

    //Lets test
    public static void main(String[] args) {

        Zombie zombie = new Zombie(5);
        Skeleton skeleton = new Skeleton();
        Ghast ghast = new Ghast();

        System.out.println(zombie.getHealth());
        System.out.println(skeleton.getHealth());
        System.out.println(ghast.getHealth());

        //one neat feature of this polymorphism topic that we touched on earlier is that you can leverage it to be more
        //generic with your code logic.

        //For example, what if you wanted to create an array of Enemies? Would you need to create an array for each
        //enemy type? NOPE! you can create an array of the super class and all can be stored there without error?
        Enemy[] enemies = new Enemy[] {zombie, skeleton, ghast, skeleton, zombie, zombie, ghast, zombie};

        //But what happens when I want to use some functionality of a Zombie from a member of this array? Enemy doesn't
        //have the growl method, so I can't do enemies[0].growl()

        //This is where type casting comes into play. We can cast a value of a super class to an object of a subclass of
        //that super class (that didn't make sense so here is an example)
        Enemy enemy = enemies[0];
        Zombie zombieFromArray = (Zombie) enemy;
        zombieFromArray.growl();
        //Above you can see we are casting the first element in the enemies array to a zombie so that we can use
        //functionality defined on the zombie class. Note, that if you tried to cast a skeleton to a zombie an error
        //would be thrown. If you need to make sure that a value is of the type you are casting you can do that with
        //and instanceof check like below
        System.out.println("Start of Kaden Thing");
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] instanceof Zombie) {
                ((Zombie) enemies[i]).growl();
            }
        }
        for (Enemy enemy1: enemies) {
            if (enemy1 instanceof Zombie zombie1) {
                zombie1.growl();
            }
        }

        //This will make sure that there will be no errors thrown about this cast.
    }
}
