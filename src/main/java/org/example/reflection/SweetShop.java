package org.example.reflection;

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading candy");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("Inside main");
        new Candy();

        System.out.println("After create Candy");

        try {
            Class.forName("org.example.reflection.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }

        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After creating Cookie");
    }

}
