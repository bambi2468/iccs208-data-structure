import java.util.Comparator;
import java.util.function.*;

interface IntToIntFunc {
    Integer apply(Integer x);
}

class MulByTwo implements IntToIntFunc {
    @Override
    public Integer apply(Integer x) {
        return 2 * x;
    }
}

class MulByN implements IntToIntFunc {
    private int n;

    MulByN(int n) {
        this.n = n;
    }

    @Override
    public Integer apply(Integer x) {
        return 2 * n;
    }
}

class Cat implements Comparable<Cat>{
    String name;
    int weight;
    int age;

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    public int compareto(Cat other){
        return this.age > other.age;
    }
}

public class L7 {
    // return the index where the largest items appears
    // public static int maxIndex(int[] items) {
    // if (items.length == 0)
    // return -1;
    // int maxDex = 0;
    // for (int i= 1; i < items.length; i++) {
    // if(items[i] > items[maxDex]){
    // maxDex = i;
    // }
    // }
    // return maxDex;
    // }

    public <T> int maxIndex(T[] items, Comparator<T> cc) {
        if (items.length == 0)
            return -1;
        int maxDex = 0;
        for (int i = 1; i < items.length; i++) {
            if (cc.compare(items[i], items[maxDex]) > 0) {
                maxDex = i;
            }
        }
        return maxDex;
    }

    // public static int twice(Function<Integer,Integer> f,int x){
    // return f.apply(f.apply(x));
    // }

    // public static int twice(IntToIntFunc f,int x){
    // return f.apply(f.apply(x));
    // }

    // public static Integer mulByTwo(Integer x){
    // return 2*x;
    // }

    public static void main(String[] args) {
        Integer[] arr = { 5, 1, 4, 7, 2 };
        int maxArrIndex = maxIndex(arr, Integer::compare);
        maxArrIndex = maxIndex(arr, (Integer x, Integer y) -> x - y);
        Cat[] felines = { new Cat("Cat 1", 25, 2),
                        new Cat("Cat 2", 12, 3)};

        int maxFelineIndex = maxIndex(felines, (Cat x,Cat y) -> Integer.compare(x.weight,y.weight));
        maxArrIndex = maxIndex(arr);
        maxFelineIndex = maxIndex(felines);
        // IntToIntFunc f = new MulByTwo();
        // int r = twice(f,5);
        // Function<Integer,Integer> f = L7::mulByTwo;

        // int r = twice(f, 5);
        // System.out.println(r);
        // int s = twice((Integer x) -> x+3, 7);
    }
}
