package com.slyvr.api.upgrade.shop.item;

import com.slyvr.api.shop.item.Buyable;
import com.slyvr.api.shop.item.ItemDescription;
import com.slyvr.api.trap.Trap;

public interface TrapItem extends Buyable {

    String getName();

    Trap getTrap();

    ItemDescription getDescription();

}