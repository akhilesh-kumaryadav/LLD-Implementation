package InventorySystem.Order;

import java.util.Map;

import InventorySystem.User.User;
import InventorySystem.Address.Address;
import InventorySystem.WareHouse.WareHouse;
import InventorySystem.Invoice.Invoice;
import InventorySystem.Payment.Payment;
import InventorySystem.Payment.PaymentMode;
import InventorySystem.Payment.UPIPaymentMode;
import InventorySystem.Order.OrderStatus;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryAndCountMap;
    WareHouse wareHouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user, WareHouse wareHouse) {
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.wareHouse = wareHouse;
        this.deliveryAddress = user.getUserAddress();
        this.invoice = new Invoice();
        this.invoice.generateInvoice(this);
    }

    public void checkout() {
        wareHouse.removeItemFromInventory(productCategoryAndCountMap);

        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        if (isPaymentSuccess) {
            user.getUserCart().emptyCart();
        } else {
            wareHouse.addItemToInventory(productCategoryAndCountMap);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        this.payment = new Payment(paymentMode);
        return this.payment.makePayment();
    }

    public void generateOrderInvoice() {
        this.invoice.generateInvoice(this);
    }
}