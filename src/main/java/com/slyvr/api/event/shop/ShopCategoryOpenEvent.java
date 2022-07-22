package com.slyvr.api.event.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.Category;
import com.slyvr.api.shop.Shop;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class ShopCategoryOpenEvent extends ShopEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final GamePlayer gp;
    private boolean isCancelled;

    public ShopCategoryOpenEvent(GamePlayer player, Shop shop, Category category) {
        super(shop, category);

        this.gp = player;
    }

    public static HandlerList getHandlerList() {
        return ShopCategoryOpenEvent.HANDLERS;
    }

    public GamePlayer getPlayer() {
        return this.gp;
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
        return ShopCategoryOpenEvent.HANDLERS;
    }

}