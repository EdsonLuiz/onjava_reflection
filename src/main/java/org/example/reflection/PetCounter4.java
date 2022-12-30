package org.example.reflection;

import org.example.onjava.TypeCounter;
import org.example.reflection.pests.Pet;
import org.example.reflection.pests.PetCreator;

public class PetCounter4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        new PetCreator().stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(
                        p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
    }
}
