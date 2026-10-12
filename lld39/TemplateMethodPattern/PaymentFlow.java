package TemplateMehtodPattern;

public abstract class PaymentFlow {
    public abstract void validateRequest();

    public abstract void debitAmount();

    public abstract void calculateFees();

    public abstract void creditAmount();

    // Template method: whcih defines the order of steps to execute the task;
    public final void sendMoney() {
        validateRequest();
        debitAmount();
        calculateFees();
        creditAmount();
    }

    // Hook Method: which can be overridden by the subclasses
    protected boolean requiresOTPAuthentication() {
        return false; // Default: authentication not required
    }

    // Common Method: All subclasses share this common functionality
    public void logTransaction() {
        System.out.println("Transaction Completed!");
    }
}