package CouponApply.Product;

public class Item4 extends Product {
    public Item4(String name, double originalPrice, ProductType type) {
        super(name, originalPrice, type);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}