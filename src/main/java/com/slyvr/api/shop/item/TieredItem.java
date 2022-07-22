package com.slyvr.api.shop.item;

import com.slyvr.api.game.player.GamePlayer;

import java.util.List;

public interface TieredItem extends Buyable {

    /**
     * Gets a list containing all the tiers
     *
     * @return list of tiers
     */
    List<Item> getTiers();

    /**
     * Gets the item representing the tier
     *
     * @return item representing the tier
     */
    Item getTier(int tier);

    /**
     *
     */
    TieredItemStack getPlayerTier(GamePlayer gp);

    /**
     * Checks if this item is one of the tiers
     *
     * @return true if tiers contains the item, otherwise false
     */
    boolean contains(Item item);

}