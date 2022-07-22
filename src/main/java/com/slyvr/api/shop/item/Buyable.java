package com.slyvr.api.shop.item;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.inventory.ItemStack;

public interface Buyable {

    /**
     * Gets display item of this buyable object for the specific player
     *
     * @param gp a GamePlayer
     */
    ItemStack getDisplayItem(GamePlayer gp);

    /**
     * This method will be called when the player click the item in the shop!
     *
     * @param gp player to buy the item
     *
     * @return true if the player received the item, otherwise false
     */
    boolean onBuy(GamePlayer gp);

}
