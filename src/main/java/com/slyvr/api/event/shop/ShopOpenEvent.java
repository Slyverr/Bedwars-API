package com.slyvr.api.event.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.Shop;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ShopOpenEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Shop shop;
    private final GamePlayer gp;
    private boolean isCancelled;

    public ShopOpenEvent(GamePlayer player, Shop shop) {

        this.gp = player;
        this.shop = shop;
    }

    public static HandlerList getHandlerList() {
        return ShopOpenEvent.HANDLERS;
    }

    public GamePlayer getPlayer() {
        return this.gp;
    }

    public Shop getShop() {
        return this.shop;
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
        return ShopOpenEvent.HANDLERS;
    }

}