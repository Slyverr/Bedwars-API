package com.slyvr.api.event.upgrade;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.upgrade.shop.UpgradeShop;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UpgradeShopCloseEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UpgradeShop shop;
    private final GamePlayer player;

    public UpgradeShopCloseEvent(UpgradeShop shop, GamePlayer player) {

        this.shop = shop;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return UpgradeShopCloseEvent.HANDLERS;
    }

    public UpgradeShop getShop() {
        return this.shop;
    }

    public GamePlayer getPlayer() {
        return this.player;
    }

    @Override
    public HandlerList getHandlers() {
        return UpgradeShopCloseEvent.HANDLERS;
    }

}