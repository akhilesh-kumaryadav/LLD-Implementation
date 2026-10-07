package SingletonPattern;

public class DbConnectionDoubleLocking {
    // The single instance is created when it is required
    private static DbConnectionDoubleLocking instance = null;

    // The privarte constructor prevents instantiation
    private DbConnectionDoubleLocking() {

    }

    // Throead Safe method to return the unique instance of this class
    public static DbConnectionDoubleLocking getInstance() {
        if (instance == null) { // First check
            synchronized (DbConnectionDoubleLocking.class) {
                if (instance == null) {
                    instance = new DbConnectionDoubleLocking();
                }
            }
        }
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("DoubleLocking Initialization - Singleton - " + this);
    }
}