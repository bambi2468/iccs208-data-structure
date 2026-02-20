### Problem Statement

Write a Java method `hasTripleUppercase` that takes a String as input and returns `true` if the string contains three or more consecutive uppercase letters. If the string does not contain at least three consecutive uppercase letters, or if the string is `null` or shorter than three characters, the method should return `false`.

### Input / Output Examples

* `hasTripleUppercase("abc")`        => `false`
* `hasTripleUppercase("abCDef")`     => `false`
* `hasTripleUppercase("abCDEf")`     => `true`
* `hasTripleUppercase("WOW")`        => `true`
* `hasTripleUppercase("HeLLoWORLD")` => `true`
* `hasTripleUppercase("A B C")`      => `false`

### Initial Skeleton

```java
public class TripleUppercase {

    public static boolean hasTripleUppercase(String st) {
        // TODO: Implement your logic here
        return false;
    }

    public static void main(String[] args) {
        // TODO: Test your code here
    }
}

```