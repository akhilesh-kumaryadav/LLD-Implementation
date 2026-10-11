package CouponApply.Product;

public class Item3 extends Product {
    public Item3(String name, double originalPrice, ProductType type) {
        super(name, originalPrice, type);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}