package com.slyvr.api.game.player;

import com.slyvr.api.shop.item.TieredItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Set;
import java.util.function.Predicate;

public interface GameInventory {

    Set<ItemStack> getPermanentItems();

    boolean addItem(ItemStack item);

    boolean removeItem(ItemStack item);

    Set<TieredItemStack> getTieredItems();

    boolean addTieredItem(TieredItemStack item);

    boolean removeTieredItem(TieredItemStack item);

    boolean contains(ItemStack item);

    boolean contains(ItemStack item, Predicate<ItemStack> predicate);

    boolean contains(TieredItemStack item);

    void clear();

}