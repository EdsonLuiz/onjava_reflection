package org.example.reflection.pests;

import org.example.reflection.PetCounter;

public class PetCounter2 {
    public static void main(String[] args) {
        new PetCounter().count(new PetCreator());
    }
}
