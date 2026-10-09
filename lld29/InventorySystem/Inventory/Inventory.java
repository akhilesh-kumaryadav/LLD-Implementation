package InventorySystem.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import InventorySystem.Product.ProductCategory;
import InventorySystem.Product.Product;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public void addCategory(int categoryId, String name, int price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setPrice(price);
        productCategory.setCategoryName(name);
        productCategory.setProductCategoryId(categoryId);

        productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int productCategoryId) {
        ProductCategory productCategory = null;
        for (ProductCategory category : productCategoryList) {
            if (category.getProductCategoryId() == productCategoryId) {
                productCategory = category;
            }
        }

        if (productCategory != null) {
            productCategory.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) {
        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory productCategory = getProductCategoryFromId(entry.getKey());
            productCategory.removeProduct(entry.getValue());
        }
    }

    private ProductCategory getProductCategoryFromId(int productCategoryId) {
        for (ProductCategory productCategory : productCategoryList) {
            if (productCategory.getProductCategoryId() == productCategoryId) {
                return productCategory;
            }
        }

        return null;
    }

    public List<ProductCategory> getProductCategoryList() {
        return this.productCategoryList;
    }
}
