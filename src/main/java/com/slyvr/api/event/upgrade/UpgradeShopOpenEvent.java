package com.slyvr.api.event.upgrade;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.upgrade.shop.UpgradeShop;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UpgradeShopOpenEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UpgradeShop shop;
    private final GamePlayer player;

    private boolean isCancelled;

    public UpgradeShopOpenEvent(UpgradeShop shop, GamePlayer player) {

        this.shop = shop;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return UpgradeShopOpenEvent.HANDLERS;
    }

    public UpgradeShop getShop() {
        return this.shop;
    }

    public GamePlayer getPlayer() {
        return this.player;
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
        return UpgradeShopOpenEvent.HANDLERS;
    }

}
