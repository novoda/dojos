package com.novoda.gameofthrones;

import java.util.ArrayList;
import java.util.List;

public class CharactersProvider {
    static List<Character> getCharacters() {
        List<Character> characters = new ArrayList<>();

        characters.add(new Character("Daenerys Targaryen", "https://en.wikipedia.org/wiki/Daenerys_Targaryen"));
        characters.add(new Character("Jon Snow", "https://en.wikipedia.org/wiki/Jon_Snow_(character)"));
        characters.add(new Character("Cersei Lannister", "https://en.wikipedia.org/wiki/Cersei_Lannister"));
        characters.add(new Character("Jaime Lannister", "https://en.wikipedia.org/wiki/Jaime_Lannister"));
        characters.add(new Character("Sansa Stark", "https://en.wikipedia.org/wiki/Sansa_Stark"));
        characters.add(new Character("Arya Stark", "https://en.wikipedia.org/wiki/Arya_Stark"));
        characters.add(new Character("Theon Greyjoy", "https://en.wikipedia.org/wiki/Theon_Greyjoy"));
        characters.add(new Character("Sandor Clegane", "https://en.wikipedia.org/wiki/Sandor_Clegane"));

        return characters;
    }
}
