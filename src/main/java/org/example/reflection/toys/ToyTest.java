package org.example.reflection.toys;

interface HasBatteries {}
interface Waterprof {}
interface Shoots {}

class Toy {
    // Comment out the following zero-argument
    // constructor to see NoSuchMethodError
    public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterprof, Shoots {
    public FancyToy() {super(1);}
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("org.example.reflection.toys.FancyToy");

        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        for(Class face : c.getInterfaces())
            printInfo(face);

        Class up = c.getSuperclass();
        Object object = null;

        try {
            // Requires public zero-argument constructor:
            object = up.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate");
        }

        printInfo(object.getClass());
    }
}
