package org.example.reflection;

import org.example.reflection.PetCounter;
import org.example.reflection.pests.PetCreator;

public class PetCounter2 {
    public static void main(String[] args) {
        new PetCounter().count(new PetCreator());
    }
}
