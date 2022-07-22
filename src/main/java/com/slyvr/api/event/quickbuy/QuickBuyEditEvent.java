package com.slyvr.api.event.quickbuy;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.QuickBuy;
import com.slyvr.api.shop.item.Buyable;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class QuickBuyEditEvent extends QuickBuyEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public QuickBuyEditEvent(GamePlayer owner, QuickBuy quickbuy, Buyable buyable, QuickBuyAction action) {
        super(owner, quickbuy);
    }

    public static HandlerList getHandlerList() {
        return QuickBuyEditEvent.HANDLERS;
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
        return QuickBuyEditEvent.HANDLERS;
    }

    public enum QuickBuyAction {

        REMOVE,
        REPLACE,
        SET

    }

}
