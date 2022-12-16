package org.example.reflection;

public class BoundedClassReferences {
    /**
     *
     * To create a Class reference constrained to a type
     * or any subtype, you can combine the wildcard with the extends keyword
     * to create a bound.
     *
     */
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Or anything else derived from Number.
    }
}
