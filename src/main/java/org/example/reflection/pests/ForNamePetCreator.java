package org.example.reflection.pests;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends Creator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();
    // Types you want randomly created:
    private static String[] typeNames = {
            "org.example.reflection.pests.Mutt",
            "org.example.reflection.pests.Pug",
            "org.example.reflection.pests.EgyptianMau",
            "org.example.reflection.pests.Manx",
            "org.example.reflection.pests.Cymric",
            "org.example.reflection.pests.Rat",
            "org.example.reflection.pests.Mouse",
            "org.example.reflection.pests.Hamster"
    };

    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name)
                );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
