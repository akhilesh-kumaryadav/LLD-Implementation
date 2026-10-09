package InventorySystem;

import java.util.ArrayList;
import java.util.List;

import InventorySystem.WareHouse.WareHouse;
import InventorySystem.WareHouse.NearestWareHouseSelectionStrategy;
import InventorySystem.Inventory.Inventory;
import InventorySystem.Product.Product;
import InventorySystem.User.User;
import InventorySystem.Product.ProductCategory;
import InventorySystem.Order.Order;
import InventorySystem.Address.Address;

public class Demo {
    private WareHouse addWareHouseAndItsInventory() {
        WareHouse wareHouse = new WareHouse();
        Inventory inventory = new Inventory();

        inventory.addCategory(0001, "Pepsi Large Cold Drink", 100);
        inventory.addCategory(0004, "Dove Small Soap", 50);

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("Pepsi");

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("Pepsi");

        Product product3 = new Product();
        product3.setProductId(3);
        product3.setProductName("Dove");

        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        wareHouse.setInventory(inventory);

        return wareHouse;
    }

    private User createUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("AKY");
        user.setAddress(new Address(122015, "Gurugram", "State"));

        return user;
    }

    private void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId) {
        User user = productDeliverySystem.getUser(userId);

        WareHouse wareHouse = productDeliverySystem.getWareHouse(new NearestWareHouseSelectionStrategy());

        Inventory inventory = productDeliverySystem.getInventory(wareHouse);

        ProductCategory productCategoryIWantToOrder = null;

        for (ProductCategory productCategory : inventory.getProductCategoryList()) {
            if (productCategory.getCategoryName().equals("Pepsi Large Cold Drink")) {
                productCategoryIWantToOrder = productCategory;
            }
        }

        productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);

        Order order = productDeliverySystem.placeOrder(user, wareHouse);

        productDeliverySystem.checkout(order);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        List<WareHouse> wareHouseList = new ArrayList<>();
        wareHouseList.add(demo.addWareHouseAndItsInventory());

        List<User> userList = new ArrayList<>();
        userList.add(demo.createUser());

        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, wareHouseList);

        demo.runDeliveryFlow(productDeliverySystem, 1);
    }
}