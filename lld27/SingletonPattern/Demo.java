package SingletonPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=====> Singleton Design Pattern <=====");

        System.out.println("=====> Testing Eager Initialization <=====");
        DbConnectionEager eager1 = DbConnectionEager.getInstance();
        DbConnectionEager eager2 = DbConnectionEager.getInstance();
        eager1.displayMessage();
        eager2.displayMessage();
        System.out.println("Same instance? -> " + (eager1 == eager2));

        System.out.println("=====> Testing Lazy Initialization <=====");
        DbConnectionEager lazy1 = DbConnectionEager.getInstance();
        DbConnectionEager lazy2 = DbConnectionEager.getInstance();
        lazy1.displayMessage();
        lazy2.displayMessage();
        System.out.println("Same instance? -> " + (lazy1 == lazy2));

        System.out.println("=====> Testing Thread Safe Initialization <=====");
        DbConnectionEager threadSafe1 = DbConnectionEager.getInstance();
        DbConnectionEager threadSafe2 = DbConnectionEager.getInstance();
        threadSafe1.displayMessage();
        threadSafe2.displayMessage();
        System.out.println("Same instance? -> " + (threadSafe1 == threadSafe2));

        System.out.println("=====> Testing Double Locking Initialization <=====");
        DbConnectionEager doubleChecking1 = DbConnectionEager.getInstance();
        DbConnectionEager doubleChecking2 = DbConnectionEager.getInstance();
        doubleChecking1.displayMessage();
        doubleChecking2.displayMessage();
        System.out.println("Same instance? -> " + (doubleChecking1 == doubleChecking2));

        System.out.println("=====> Testing Double Locking Initialization Fixed <=====");
        DbConnectionEager doubleCheckingFixed1 = DbConnectionEager.getInstance();
        DbConnectionEager doubleCheckingFixed2 = DbConnectionEager.getInstance();
        doubleCheckingFixed1.displayMessage();
        doubleCheckingFixed2.displayMessage();
        System.out.println("Same instance? -> " + (doubleCheckingFixed1 == doubleCheckingFixed2));
    }
}