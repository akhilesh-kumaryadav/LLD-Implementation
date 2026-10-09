package InventorySystem.WareHouse;

import java.util.Map;

import InventorySystem.Inventory.Inventory;
import InventorySystem.Address.Address;

public class WareHouse {
    Inventory inventory;
    Address address;

    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        // It will update the items in the inventory based upon product category;
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        // It will update the items in the inventory based upon product category;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}