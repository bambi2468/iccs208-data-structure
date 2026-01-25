interface I<T> {
    T work();
    
}

class A<T extends Number> implements I<T>{
    

    @Override
    public T work() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'work'");
    }

}

abstract class B<V> implements I<V>{

}

class C<T> extends B<T>{

    @Override
    public T work() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'work'");
    }
    <X> X walk(){
        return null;
    }
}

public class InterfaceMain {
    public static void main(String[] args) {
        C<?> c1 = new C<>();
        c1.work();
        A<?> a2 = new A();
        a2.work();
        A<Double> a = new A<>(); 
        A<Integer> a1 = new A<>(); 
        C<String> c = new C<>();
        I<String> i = new C<>();
        // I<String> i1 = a;
        Number n = new Double(2.5);
        // I<Number> i1 = a;
        Integer p = c.walk();
        System.out.println(i);
    }
}
