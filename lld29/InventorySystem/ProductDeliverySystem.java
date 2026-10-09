package InventorySystem;

import java.util.List;

import InventorySystem.User.User;
import InventorySystem.User.UserController;
import InventorySystem.WareHouse.WareHouse;
import InventorySystem.WareHouse.WareHouseController;
import InventorySystem.WareHouse.WareHouseSelectionStrategy;
import InventorySystem.Inventory.Inventory;
import InventorySystem.Order.Order;
import InventorySystem.Order.OrderController;
import InventorySystem.Product.ProductCategory;
import InventorySystem.Cart.Cart;

public class ProductDeliverySystem {
    UserController userController;
    WareHouseController wareHouseController;
    OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<WareHouse> wareHouseList) {
        userController = new UserController(userList);
        wareHouseController = new WareHouseController(wareHouseList, null);
        orderController = new OrderController();
    }

    public User getUser(int userId) {
        return userController.getUser(userId);
    }

    public WareHouse getWareHouse(
            WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        return wareHouseController.selectWareHouse(
                wareHouseSelectionStrategy);
    }

    public Inventory getInventory(WareHouse wareHouse) {
        return wareHouse.getInventory();
    }

    public void addProductToCart(User user, ProductCategory productCategory, int count) {
        Cart cart = user.getUserCart();
        cart.addItemInCart(productCategory.getProductCategoryId(), count);
    }

    public Order placeOrder(User user, WareHouse wareHouse) {
        return orderController.createNewOrder(user, wareHouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }
}