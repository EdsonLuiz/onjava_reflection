package org.example.reflection;

class Building {}

class House extends Building {}

/**
 * cast() is useful when you're writing generic code, and you've stored
 * a Class reference to use for casting.
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        // House h = House.class.cast(b);
        h = (House)b; // ... or just do this.
     }
}
