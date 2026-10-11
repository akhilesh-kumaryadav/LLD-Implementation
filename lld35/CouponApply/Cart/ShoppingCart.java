package CouponApply.Cart;

import CouponApply.Product.Product;

import java.util.ArrayList;
import java.util.List;

import CouponApply.Coupons.PercentageCouponDecorator;
import CouponApply.Coupons.TypeCouponDecorator;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        // Decorate the product with applicable coupons
        Product productWithEligibleDiscount = new TypeCouponDecorator(new PercentageCouponDecorator(product, 20), 10);

        productList.add(productWithEligibleDiscount);
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        // ProductList consts decorated products;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }
}