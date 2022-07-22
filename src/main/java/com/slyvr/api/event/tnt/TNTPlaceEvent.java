package com.slyvr.api.event.tnt;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class TNTPlaceEvent extends TNTEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public TNTPlaceEvent(GamePlayer gp, TNTPrimed tnt) {
        super(gp, tnt);
    }

    public static HandlerList getHandlerList() {
        return TNTPlaceEvent.HANDLERS;
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
        return TNTPlaceEvent.HANDLERS;
    }
}
