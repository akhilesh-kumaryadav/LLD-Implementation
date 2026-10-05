package FacadePattern;

public class NotificationService {
    public boolean sendConfirmation(String productId) {
        System.out.println("Sending order confirmation for product: " + productId);
        return true;
    }
}