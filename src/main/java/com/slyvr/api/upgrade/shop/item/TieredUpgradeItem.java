package com.slyvr.api.upgrade.shop.item;

import com.slyvr.api.shop.item.Buyable;
import com.slyvr.api.shop.item.ItemDescription;
import com.slyvr.api.upgrade.TieredUpgrade;

import java.util.List;

public interface TieredUpgradeItem extends Buyable {

    String getName();

    TieredUpgrade getUpgrade();

    List<TieredUpgradeItemTier> getTiers();

    TieredUpgradeItemTier getTier(int tier);

    ItemDescription getDescription();

}
