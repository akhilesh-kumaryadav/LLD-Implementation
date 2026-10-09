package InventorySystem.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int productCategoryId;
    String categoryName;
    List<Product> products = new ArrayList<>();
    double price;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(int count) {
        for (int i = 1; i <= count; i++) {
            this.products.remove(0);
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductCategoryList() {
        return this.products;
    }
}