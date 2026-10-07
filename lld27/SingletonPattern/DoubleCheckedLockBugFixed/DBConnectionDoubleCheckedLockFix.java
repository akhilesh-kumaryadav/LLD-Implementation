package SingletonPattern.DoubleCheckedLockBugFixed;

public class DBConnectionDoubleCheckedLockFix {
    // The single instance is created when it is required
    private static volatile DBConnectionDoubleCheckedLockFix instance = null;
    int portNumber;

    // The privarte constructor prevents instantiation
    private DBConnectionDoubleCheckedLockFix(int portNumber) {
        this.portNumber = portNumber;
    }

    // Throead Safe method to return the unique instance of this class
    public static DBConnectionDoubleCheckedLockFix getInstance(int portNumber) {
        if (instance == null) { // First check
            synchronized (DBConnectionDoubleCheckedLockFix.class) {
                if (instance == null) {
                    instance = new DBConnectionDoubleCheckedLockFix(portNumber);
                }
            }
        }
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("Singleton - Double Checked Locking - Fix -  " + this);
    }
}