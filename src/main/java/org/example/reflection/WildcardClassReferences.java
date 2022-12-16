package org.example.reflection;

public class WildcardClassReferences {
    public static void main(String[] args) {
        // Indicates You chose the non-specific version of Class
        Class<?> intClass = int.class;
        intClass = double.class;

    }
}
