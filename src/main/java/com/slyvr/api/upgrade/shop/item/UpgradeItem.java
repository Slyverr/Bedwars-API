package com.slyvr.api.upgrade.shop.item;

import com.slyvr.api.shop.item.Buyable;
import com.slyvr.api.shop.item.ItemCost;
import com.slyvr.api.shop.item.ItemDescription;
import com.slyvr.api.upgrade.Upgrade;

public interface UpgradeItem extends Buyable {

    String getName();

    Upgrade getUpgrade();

    ItemCost getCost();

    ItemDescription getDescription();

}
