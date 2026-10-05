package FacadePattern;

public class PaymentService {
    public boolean makePayment(String productId) {
        System.out.println("Processing payment using: " + productId);
        return true;
    }
}