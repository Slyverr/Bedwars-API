package com.slyvr.api.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.item.Buyable;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface Category {

    /**
     * Gets category display name
     *
     * @return categroy display name
     */
    String getName();

    /**
     * Gets category display item
     *
     * @return category display item
     */
    ItemStack getDisplayItem();

    /**
     * Gets category items
     *
     * @return {@code Map} containing all category items and their slot
     */
    Map<Integer, Buyable> getItems();

    /**
     * Sets and replace existing items with the given items If the Map contain null item it will not be
     * added!
     *
     * @param items {@code Map} containing items and their slot
     */
    void setItems(Map<Integer, Buyable> items);

    /**
     * Adds item to this category
     *
     * @param items items to add to this category
     */
    void addItems(Buyable... items);

    /**
     * Gets item in present in the slot
     *
     * @return item in the current slot if exists
     */
    Buyable getItem(int slot);

    /**
     * Sets item in the given slot
     *
     * @param slot slot to set item to
     * @param item item to set
     */
    void setItem(int slot, Buyable item);

    /**
     * Removes {@code ShopItem} present in the given slot
     *
     * @param slot item slot
     *
     * @return previous item in the slot
     */
    Buyable removeItem(int slot);

    /**
     * Removes {@code ShopItem} present in the given slot
     *
     * @param item item to remove
     *
     * @return true if the item exist and has been removed, otherwise false
     */
    boolean removeItem(Buyable item);

    /**
     *
     */
    void applyItems(Inventory inv, GamePlayer gp);

    /**
     * Removes every item in the category
     */
    void clear();
}