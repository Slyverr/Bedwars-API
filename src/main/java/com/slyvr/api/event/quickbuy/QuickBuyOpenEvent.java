package com.slyvr.api.event.quickbuy;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.QuickBuy;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class QuickBuyOpenEvent extends QuickBuyEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public QuickBuyOpenEvent(GamePlayer player, QuickBuy quickbuy) {
        super(player, quickbuy);

    }

    public static HandlerList getHandlerList() {
        return QuickBuyOpenEvent.HANDLERS;
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
        return QuickBuyOpenEvent.HANDLERS;
    }

}