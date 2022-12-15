package org.example.reflection;

import java.util.*;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

/**
 * Preparing a class for use:
 *
 * 1- Loading, find the bytecodes and creates a Class object from those bytecodes.
 *
 * 2- Linking, verifies the bytecodes, allocates storage for static fields, if necessary resolves all references to
 *      other classes made by this class.
 *
 * 3- Initialization, if exists initialize superclass. Execute static initializers and static initialization blocks.
 */
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After create Initable ref");

        // Does no trigger initialization:
        System.out.println(Initable.STATIC_FINAL);

        // Triggers initialization:
        System.out.println(Initable.STATIC_FINAL2);

        // Triggers initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("org.example.reflection.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
