package com.slyvr.api.event.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.Category;
import com.slyvr.api.shop.Shop;
import com.slyvr.api.shop.item.Buyable;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class ShopItemClickEvent extends ShopEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final GamePlayer gp;
    private final Buyable item;
    private boolean isCancelled;

    public ShopItemClickEvent(GamePlayer player, Shop shop, Category category, Buyable item) {
        super(shop, category);

        this.gp = player;
        this.item = item;
    }

    public static HandlerList getHandlerList() {
        return ShopItemClickEvent.HANDLERS;
    }

    public GamePlayer getWhoClicked() {
        return this.gp;
    }

    public Buyable getClickedItem() {
        return this.item;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return ShopItemClickEvent.HANDLERS;
    }

}