package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.upgrade.shop.item.UpgradeItem;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GamePlayerUpgradeBuyEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UpgradeItem item;
    private String message;

    private boolean isCancelled;

    public GamePlayerUpgradeBuyEvent(GamePlayer player, UpgradeItem item, String message) {
        super(player);

        this.item = item;
        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerUpgradeBuyEvent.HANDLERS;
    }

    public UpgradeItem getItem() {
        return this.item;
    }

    public String getBuyMessage() {
        return this.message;
    }

    public void setBuyMessage(String message) {
        this.message = message;
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
        return GamePlayerUpgradeBuyEvent.HANDLERS;
    }

}