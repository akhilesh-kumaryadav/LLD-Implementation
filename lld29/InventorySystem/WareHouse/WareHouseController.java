package InventorySystem.WareHouse;

import java.util.List;

public class WareHouseController {
    List<WareHouse> wareHouseList;
    WareHouseSelectionStrategy wareHouseSelectionStratery = null;

    public WareHouseController(List<WareHouse> wareHouseList, WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseList = wareHouseList;
        this.wareHouseSelectionStratery = wareHouseSelectionStrategy;
    }

    public void addNewWareHouse(WareHouse wareHouse) {
        this.wareHouseList.add(wareHouse);
    }

    public void removeWareHouse(WareHouse wareHouse) {
        this.wareHouseList.remove(wareHouse);
    }

    public WareHouse selectWareHouse(WareHouseSelectionStrategy selectionStrategy) {
        this.wareHouseSelectionStratery = selectionStrategy;

        return wareHouseSelectionStratery.selectWareHouse(wareHouseList);
    }
}