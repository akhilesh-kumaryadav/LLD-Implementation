package WordProcessor.Solution;

// Concreate Flywieght (Class) -> implements the Flywieght interface and stores intrinsic state
public class DocumentCharacter implements ILetter {
    // Intrinsic data -> shared data -> common to all objects
    private final char character;
    private final String fontType;
    private final int size;

    public DocumentCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    // Getter methods only
    @Override
    public void display(int row, int column) {
        // Display the character of particluar font and size at given location
        System.out.println("Displaying " + character + " at row " + row + " and column " + column);
    }
}