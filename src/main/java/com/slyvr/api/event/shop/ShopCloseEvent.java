package com.slyvr.api.event.shop;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.Category;
import com.slyvr.api.shop.Shop;
import org.bukkit.event.HandlerList;

public class ShopCloseEvent extends ShopEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer player;

    public ShopCloseEvent(GamePlayer player, Shop shop, Category category) {
        super(shop, category);

        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return ShopCloseEvent.HANDLERS;
    }

    public GamePlayer getPlayer() {
        return this.player;
    }

    @Override
    public HandlerList getHandlers() {
        return ShopCloseEvent.HANDLERS;
    }

}