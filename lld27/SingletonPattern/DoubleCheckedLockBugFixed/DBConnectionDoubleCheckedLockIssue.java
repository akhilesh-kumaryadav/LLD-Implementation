package SingletonPattern.DoubleCheckedLockBugFixed;

public class DBConnectionDoubleCheckedLockIssue {
    // The single instance is created when it is required
    private static DBConnectionDoubleCheckedLockIssue instance = null;
    int portNumber;

    // The privarte constructor prevents instantiation
    private DBConnectionDoubleCheckedLockIssue(int portNumber) {
        this.portNumber = portNumber;
    }

    // Throead Safe method to return the unique instance of this class
    public static DBConnectionDoubleCheckedLockIssue getInstance() {
        if (instance == null) { // First check
            synchronized (DBConnectionDoubleCheckedLockIssue.class) {
                if (instance == null) {
                    instance = new DBConnectionDoubleCheckedLockIssue(5567);
                }
            }
        }
        return instance;
    }

    // Method to display a message
    public void displayMessage() {
        System.out.println("Singleton - Double Checked Locking - Issue -  " + this);
    }
}