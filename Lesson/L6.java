// interface Series {
//     int next();

//     void reset();
// }

// class ConstFive implements Series {
//     // every method that is part of an interface must be public
//     public int next() {
//         return 5;
//     }

//     public void reset() {
//         /* do nothing */}
// }

// // 1, 3, 5, 7,...

// class OddNumber implements Series {
//     private int num = 1;

//     public int next() {
//         int toReturn = num;
//         num += 2;
//         return toReturn;
//     }

//     public void reset() {
//         num = 1;
//     }

//     public int magicFoo() {
//         return 42 * num;
//     }
// }

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Animal{
    void walk() {System.out.println("Animal: I'm walking");}
    void eat() {System.out.println("Animal: I'm eating");}
}

class Pet extends Animal{
    void play(String with) {System.out.println("Pet: playing with" + with);}
}

class Parrot extends Pet{
    void sing() {System.out.println("Parrot: singing");}
}

class Cat extends Pet{
    void meow(){System.out.println("Cat: meowing");}
}

public class L6 {
    // static int sumList(ArrayList<Integer> list) {
    //     int total = 0;
    //     for (int num : list) {
    //         total += num;
    //     }
    //     return total;
    // }

    // static int sumList(LinkedList<Integer> list) {
    //     int total = 0;
    //     for (int num : list) {
    //         total += num;
    //     }
    //     return total;
    // }

    // static int sumList(List<Integer> list) {
    //     int total = 0;
    //     for (int num : list) {
    //         total += num;
    //     }
    //     return total;
    // }

    public static void main(String[] args) {
        // OddNumber on = new OddNumber();
        // ConstFive cf = new ConstFive();
        // Series s1 = on;
        // Series[] ss = { on, cf };
        // System.out.println(on.magicFoo());
        // System.out.println(s1.magicFoo());
        // ArrayList<Integer> al = new ArrayList<>();
        // List<Integer> list = new List<>();
        // List<Integer> list = new LinkedList<>();// new ArrayList<>();
        Animal a = new Animal();
        Pet p = new Pet();
        p.walk();
        // p.play();

    }
}
