package SingletonPattern;

public class DbConnectionThreadSafe {
    // The single instance is created when it is required
    private static DbConnectionThreadSafe instance = null;

    // The privarte constructor prevents instantiation
    private DbConnectionThreadSafe() {

    }

    // Throead Safe method to return the unique instance of this class
    public static synchronized DbConnectionThreadSafe getInstance() {
        if (instance == null) {
            instance = new DbConnectionThreadSafe();
        }
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("ThreadSafe Initialization - Singleton - " + this);
    }
}