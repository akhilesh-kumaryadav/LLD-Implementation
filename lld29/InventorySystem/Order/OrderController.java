package InventorySystem.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import InventorySystem.User.User;
import InventorySystem.WareHouse.WareHouse;

public class OrderController {
    List<Order> orderList;
    Map<Integer, List<Order>> userIdVsOrders;

    public OrderController() {
        this.orderList = new ArrayList<>();
        this.userIdVsOrders = new HashMap<>();
    }

    public Order createNewOrder(User user, WareHouse wareHouse) {
        Order order = new Order(user, wareHouse);
        this.orderList.add(order);

        if (this.userIdVsOrders.containsKey(user.getUserId())) {
            List<Order> userOrders = userIdVsOrders.get(user.getUserId());
            userOrders.add(order);
            userIdVsOrders.put(user.getUserId(), userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIdVsOrders.put(user.getUserId(), userOrders);
        }

        return order;
    }

    public void removeOrder(Order order) {
        // Remove order capability goes here
    }

    public List<Order> getOrderByCustomerId(int userId) {
        return null;
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }
}