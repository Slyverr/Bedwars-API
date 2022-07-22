package com.slyvr.api.event.fireball;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.Fireball;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class FireballLaunchEvent extends FireballEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public FireballLaunchEvent(GamePlayer owner, Fireball fireball) {
        super(owner, fireball);
    }

    public static HandlerList getHandlerList() {
        return FireballLaunchEvent.HANDLERS;
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
        return FireballLaunchEvent.HANDLERS;
    }

}