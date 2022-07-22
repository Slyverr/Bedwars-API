package com.slyvr.api.shop.item;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.inventory.ItemStack;

public interface Item extends Buyable {

    /**
     * Gets name representing this {@code Item}
     *
     * @return the name representing this {@code Item}
     */
    String getName();

    /**
     * Gets item description
     *
     * @return item description
     */
    ItemDescription getDescription();

    /**
     * Sets item description
     *
     * @param desc The new description
     */
    void setDescription(ItemDescription desc);

    /**
     * Gets item cost
     *
     * @return item cost of this item
     */
    ItemCost getCost();

    /**
     * Sets item cost
     *
     * @param cost The new cost
     */
    void setCost(ItemCost cost);

    /**
     *
     */
    ItemStack getRawItem(GamePlayer gp);

}