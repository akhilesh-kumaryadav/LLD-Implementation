package FacadePattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=====> Facade Design Pattern Demo <=====");

        OrderFacade orderFacade = new OrderFacade();

        // Player order with one call to Facade
        orderFacade.placeOrder("Macbook Pro", "Credit Card");

        // Place another order with one call to Facade
        orderFacade.placeOrder("Cricket Bat", "UPI");
    }
}