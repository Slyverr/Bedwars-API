package com.slyvr.api.upgrade.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.item.Buyable;

import java.util.Map;

public interface UpgradeShop {

    Map<Integer, Buyable> getItems();

    Buyable getItem(int slot);

    boolean addItem(int slot, Buyable item);

    Buyable removeItem(int slot);

    boolean openShop(GamePlayer gp);

    boolean contains(Buyable buyable);

}