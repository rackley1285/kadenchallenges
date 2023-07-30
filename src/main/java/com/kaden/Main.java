package com.kaden;

public class Main {

    public static void main(String[] args) {
        types();
        operators();
        conditions();
        arrays();
        loops();
    }

    public static void types() {

        boolean bool = true;    //1 bit     (0 to 1) aka true or false

        byte bte = 15;          //1 byte    (-128 to 127)
        short num = 1;          //2 byte    (-32,786 to 32,7860)
        int number = 1;         //4 byte    (-2,147,483,648 to 2,147,483,647)
        long bigint = 100;      //8 bytes   (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)

        float fpnum = 0.5f;     //4 bytes   (1.4e-45 to 3.4028235e38)
        double doub = 0.5;      //8 bytes   (4.9E-324 to 1.7976931348623157e308)

        char letter = 'b';      //2 bytes   (ascii values)
        String name = "Kaden";  //x bytes   (It's a bunch of chars under the hood)

        System.out.println("Yay Types!");
    }

    public static void operators() {

        var addition = 1 + 1;           //2
        var subtraction = 1 - 1;        //0
        var multiplication = 1 * 1;     //1
        var division = 1 / 1;           //1
        var modulus = 2 % 1;            //0
        var increment = addition++;     //3
        var decrement = subtraction--;  //-1

        //      &       bitwise and             101 & 100 -> 100
        //      |       bitwise or              110 | 001 -> 111
        //      ^       bitwise xor             101 ^ 111 -> 010
        //      ~       bitwise compliment      100 ~     -> 011
        //      <<      bit shift left          011 <<    -> 110
        //      >>      bit shift right         110 >>    -> 011

        var equal = 5;                  //5
        equal += addition;              //8 (replaced)
        equal -= addition;              //6 (replaced prev)
        //      /=      etc
        //      *=      etc
        //      %=      etc
        //      &=      bitwise and assignment
        //      |=      bitwise or assignment
        //      ^=      bitwise xor assignment
        //      >>=     bit shift left assignment
        //      <<=     bit shift right assignment

        var eq = 5 == 2;            //false
        var noteq = 5 != 2;         //true
        var greater = 5 > 1;        //true
        var less = 5 < 1;           //false
        var greEq = 5 >= 2;         //true
        var lessEq = 4 <= 9;        //true

        var logicAnd = 1 < 5 && 9 > 2;      //true
        var logicOr = 1 < 5 || 9 > 2;       //true
        var logicNot = !true;               //false

        System.out.println("Yay Operators!");
    }

    private static void conditions() {

        if (true) System.out.println("yes");

        if (false) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        int num = 2;
        if (num == 1) {
            System.out.println("one");
        } else if (num == 2) {
            System.out.println("two");
            System.out.println("two is my favorite");
        } else if (num == 3) {
            System.out.println("three");
        } else {
            System.out.println("I can't count that high");
        }

        System.out.println(1 == 1 ? "yes" : "no"); //Ternary operator shorthand for if else

        switch (num) {
            case 1 -> System.out.println("one");
            case 2 -> {
                System.out.println("two");
                System.out.println("(I like two)");
            }
            case 3 -> System.out.println("three");
            default -> System.out.println("I can't count that high");
        }

        var result = switch (num) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            default -> "bruh";
        };
        System.out.println(result);
    }

    public static void arrays() {

        int[] numbers = {1, 2, 3, 4};
        System.out.println(numbers[0]);     //1
        System.out.println(numbers[3]);     //4

        numbers[1] = 7;                     //1,7,3,4

        int[][] grid = {{1, 2}, {3, 4}};    //2d array
                                            // 1 2
                                            // 3 4
        System.out.println(grid[0][1]);     //2

        int[] integers = new int[5];        //[null, null, null, null, null]
        integers[0] = 5;
    }

    public static void loops() {

        //Print numbers 0 - 9
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //Print values in set
        int[] numbers = {1, 2, 3, 4};
        for (int num: numbers) {
            System.out.println(num);
        }

        //Print values in set
        String[] names = {"kaden", "brandon", "ricky", "jarod"};
        for (String name: names) {
            System.out.println(name);
        }

        //Count to 10
        int x = 0;
        while (x <= 10) {
            x++;
        }

        //The same as a while loop but always runs at least once (first time) even if the condition is false
        do {
            System.out.println("yes");
        } while (false);

        //Counts to 4
        x=0;
        while (x < 10) {
            if (x == 5) break;      //exits the loop immediatley
            System.out.println(x);
            x++;
        }

        //counts to 10 but skips 5
        x = 0;
        while (x <= 10) {
            if (x == 5) continue;   //skips the rest of this itteration
            System.out.println(x);
            x++;
        }
    }
}