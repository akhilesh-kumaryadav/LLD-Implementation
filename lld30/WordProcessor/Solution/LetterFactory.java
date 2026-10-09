package WordProcessor.Solution;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory (Class) -> creates and manages flyweigth objects;
public class LetterFactory {
    private static final Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter createLetter(char characterValue) {
        if (characterCache.containsKey(characterValue)) {
            // If exists, return the cached character object
            return characterCache.get(characterValue);
        } else {
            // If not exists, create the character objects and cache it
            DocumentCharacter characterObject = new DocumentCharacter(characterValue, "Arial", 10);

            // Add to cache
            characterCache.put(characterValue, characterObject);

            return characterObject;
        }
    }

    public static int getTotalCharacters() {
        return characterCache.size();
    }
}