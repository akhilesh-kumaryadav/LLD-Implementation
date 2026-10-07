package SingletonPattern;

public class DbConnectionLazy {
    private static DbConnectionLazy instance = null;

    // The privarte constructor prevents instantiation
    private DbConnectionLazy() {

    }

    // Singleton object is created only when it is required
    // This method returs the unique instance of this class
    // Drawback: This implementation is not thread-safe
    public static DbConnectionLazy getInstance() {
        if (instance == null) {
            instance = new DbConnectionLazy();
        }
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("Lazy Initialization - Singleton - " + this);
    }
}