package fns;

interface HasIsLarger<T> {
    boolean isLarger(T that);
}

class Person implements HasIsLarger<Person> {
    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public boolean isLarger(Person that) {
        return this.age > that.age;
    }

    @Override
    public String toString() {
        return "Person(" + age + ")";
    }
}

public class SubtypeCompare {
    public static void main(String[] args) {
        Person p1 = new Person(13);
        Person p2 = new Person(12);
        Person[] ps = { p1, p2 };
        System.out.println(findMax(ps));
    }

    static <X extends HasIsLarger<X>> X findMax(X[] arr) {
        X max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            X x = arr[i];
            if (x.isLarger(max)) {
                max = x;
            }
        }
        return max;
    }

}
