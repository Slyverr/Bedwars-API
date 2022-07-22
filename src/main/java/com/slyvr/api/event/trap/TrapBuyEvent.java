package com.slyvr.api.event.trap;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.upgrade.shop.item.TrapItem;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class TrapBuyEvent extends TrapEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final TrapItem item;
    private String message;

    private boolean isCancelled;

    public TrapBuyEvent(TrapItem item, GamePlayer buyer, String message) {
        super(item.getTrap());

        this.item = item;
        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return TrapBuyEvent.HANDLERS;
    }

    public TrapItem getItem() {
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
        return TrapBuyEvent.HANDLERS;
    }

}