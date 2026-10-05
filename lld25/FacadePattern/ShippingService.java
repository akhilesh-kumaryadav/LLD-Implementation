package FacadePattern;

public class ShippingService {
    public boolean shipProduct(String productId) {
        System.out.println("Shipping product: " + productId);
        return true;
    }
}