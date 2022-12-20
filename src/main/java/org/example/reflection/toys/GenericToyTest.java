package org.example.reflection.toys;

/**
 * Because of vagueness, the return value of getSuperclass().newInstance()
 * is not a precise type, but just an Object.
 *
 * To get a superclass the compiler only allow {@code Class<? super FancyToy>}
 * "Some class that is a superclass of FancyToy". The compiler not accept a declaration
 * of {@code Class<Toy>}
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftc = FancyToy.class;

        // Produces exact type
        FancyToy fancyToy = ftc.getConstructor().newInstance();

        Class<? super FancyToy> up = ftc.getSuperclass();

        // This won't compile
        // Class<Toy> up2 = ftc.getSuperclass();

        // Only produces Object
        Object obj = up.getConstructor().newInstance();
    }
}
