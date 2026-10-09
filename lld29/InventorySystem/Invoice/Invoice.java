package InventorySystem.Invoice;

import InventorySystem.Order.Order;

public class Invoice {
    int totalItemPrice;
    int totalTax;
    int totalFinalPrice;

    public void generateInvoice(Order order) {
        this.totalFinalPrice = 200;
        this.totalTax = 20;
        this.totalFinalPrice = 220;
    }
}