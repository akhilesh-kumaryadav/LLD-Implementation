package InventorySystem.WareHouse;

import java.util.List;

public class NearestWareHouseSelectionStrategy extends WareHouseSelectionStrategy {
    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouseList) {
        // algo to pick the nearest algo, for now i am just picking the first warehouse
        // for the demo purpose
        return wareHouseList.get(0);
    }
}