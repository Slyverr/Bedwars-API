package com.slyvr.api.upgrade.shop.item;

import com.slyvr.api.shop.item.ItemCost;

public class TieredUpgradeItemTier {

    private final String name;
    private final ItemCost cost;

    public TieredUpgradeItemTier(String name, ItemCost cost) {

        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public ItemCost getCost() {
        return this.cost;
    }

}