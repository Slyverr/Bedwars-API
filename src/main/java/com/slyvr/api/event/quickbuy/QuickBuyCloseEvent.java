package com.slyvr.api.event.quickbuy;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.shop.QuickBuy;
import org.bukkit.event.HandlerList;

public class QuickBuyCloseEvent extends QuickBuyEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public QuickBuyCloseEvent(GamePlayer player, QuickBuy quickbuy) {
        super(player, quickbuy);
    }

    public static HandlerList getHandlerList() {
        return QuickBuyCloseEvent.HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return QuickBuyCloseEvent.HANDLERS;
    }
}
