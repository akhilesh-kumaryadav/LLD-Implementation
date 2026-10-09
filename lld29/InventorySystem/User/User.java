package InventorySystem.User;

import java.util.ArrayList;
import java.util.List;

import InventorySystem.Cart.Cart;
import InventorySystem.Address.Address;

public class User {
    int userId;
    String userName;
    Address address;
    Cart userCartDetails;
    List<Integer> orderIds;

    public User() {
        this.userCartDetails = new Cart();
        this.orderIds = new ArrayList<>();
    }

    public Cart getUserCart() {
        return this.userCartDetails;
    }

    public Address getUserAddress() {
        return this.address;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}