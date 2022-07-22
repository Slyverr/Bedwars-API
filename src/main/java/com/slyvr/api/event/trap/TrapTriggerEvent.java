package com.slyvr.api.event.trap;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.trap.Trap;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class TrapTriggerEvent extends TrapEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer who;

    private boolean isCancelled;

    public TrapTriggerEvent(Trap trap, GamePlayer who) {
        super(trap);

        this.who = who;
    }

    public static HandlerList getHandlerList() {
        return TrapTriggerEvent.HANDLERS;
    }

    public GamePlayer getPlayer() {
        return this.who;
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
        return TrapTriggerEvent.HANDLERS;
    }

}