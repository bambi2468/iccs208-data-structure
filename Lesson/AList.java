public class AList<T> {
    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        
        System.arraycopy(items, 0, items, 1, size);
        
        items[0] = x;
        size = size + 1;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size = size + 1;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T itemToRemove = items[size - 1];
        
        items[size - 1] = null; 
        
        size = size - 1;
        return itemToRemove;
    }
}


/*
 * Exercise III: Loop Invariant
 *
 * int sum(int x) { // precondition: x >= 0
 * int p = 0;
 * for (int i=0; i<x; i++) { 
 * // @loop_invariant: 0 <= i <= x and p == Math.pow(2, i) - 1
 * p += Math.pow(2, i); 
 * }
 * return p;
 * }
 * // post-condition: return 2**x - 1
 * * --- REASONING ---
 * * 1.Base Case:
 * Before the loop starts, i = 0 and p = 0.
 * Checking invariant: p == 2^0 - 1  =>  0 == 1 - 1  => 0.
 * The invariant true at the start.
 * * 2. Inductive Step:
 * Assume the invariant holds at the start of an iteration i.
 * So, p_old = 2^i - 1.
 * * Inside the loop, p_new = p_old + 2^i.
 * Substituting p_old: p_new = (2^i - 1) + 2^i
 *  p_new = 2 * (2^i) - 1
 *  p_new = 2^(i+1) - 1
 * * After the body runs, i increase by 1.
 * The formula p == 2^(i_new) - 1 now holds for the new i.
 * * 3. Termination:
 * The loop terminates when i == x.
 * Substituting x into our invariant:
 * p == 2^x - 1.
 * * This matches the required post-condition.
 */