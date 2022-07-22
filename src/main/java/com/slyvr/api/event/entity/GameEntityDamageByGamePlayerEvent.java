package com.slyvr.api.event.entity;

import com.slyvr.api.entity.GameEntity;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GameEntityDamageByGamePlayerEvent extends GameEntityEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer damager;
    private boolean isCancelled;

    public GameEntityDamageByGamePlayerEvent(GameEntity damaged, GamePlayer damager) {
        super(damaged);

        this.damager = damager;
    }

    public static HandlerList getHandlerList() {
        return GameEntityDamageByGamePlayerEvent.HANDLERS;
    }

    public GamePlayer getDamager() {
        return this.damager;
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
        return GameEntityDamageByGamePlayerEvent.HANDLERS;
    }

}