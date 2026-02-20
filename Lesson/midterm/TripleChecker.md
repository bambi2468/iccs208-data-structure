### Problem Statement

Design a generic Java class `TripleChecker<T>` that evaluates a sequence of items against a specific condition.

Implement a method `hasTriple(Iterable<T> items, Predicate<T> condition)` that accepts a generic iterable collection and a predicate function. The method must return `true` if the collection contains three or more **consecutive** elements that satisfy the provided condition (i.e., the predicate evaluates to `true`).

If no such consecutive sequence exists, or if either the `items` collection or the `condition` predicate is `null`, the method should return `false`.

### Input / Output Examples

* **Checking for Uppercase Characters:**
`hasTriple(['a', 'b', 'C', 'D', 'E', 'f'], Character::isUpperCase)`
=> `true` *(Matches 'C', 'D', 'E')*
* **Checking for Even Numbers:**
`hasTriple([1, 3, 2, 4, 6, 7], n -> n % 2 == 0)`
=> `true` *(Matches 2, 4, 6)*
* **Checking for String Length:**
`hasTriple(["hi", "cats", "dogs", "bats", "hi"], s -> s.length() == 4)`
=> `true` *(Matches "cats", "dogs", "bats")*

### Initial Skeleton

```java
import java.util.function.Predicate;

public class TripleChecker<T> {

    public boolean hasTriple(Iterable<T> items, Predicate<T> condition) {
        // TODO: Implement your logic here
        return false;
    }

}

```