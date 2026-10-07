package SingletonPattern;

public class DbConnectionEager {
    // The single instance, created immediately
    private static final DbConnectionEager instance = new DbConnectionEager();

    // The privarte constructor prevents instantiation
    private DbConnectionEager() {

    }

    // Method to return the unique instance of this class
    public static DbConnectionEager getInstance() {
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("Eager Initialization - Singleton - " + this);
    }
}