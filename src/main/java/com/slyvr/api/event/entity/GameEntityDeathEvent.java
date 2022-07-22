package com.slyvr.api.event.entity;

import com.slyvr.api.entity.GameEntity;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GameEntityDeathEvent extends GameEntityEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer killer;

    private boolean isCancelled;

    public GameEntityDeathEvent(GameEntity entity, GamePlayer killer) {
        super(entity);

        this.killer = killer;
    }

    public static HandlerList getHandlerList() {
        return GameEntityDeathEvent.HANDLERS;
    }

    public GamePlayer getKiller() {
        return this.killer;
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
        return GameEntityDeathEvent.HANDLERS;
    }

}