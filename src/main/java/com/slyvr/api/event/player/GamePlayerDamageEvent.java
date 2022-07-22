package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDamageEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;
    private final DamageCause cause;

    public GamePlayerDamageEvent(GamePlayer player, DamageCause cause) {
        super(player);

        this.cause = cause;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerDamageEvent.HANDLERS;
    }

    public DamageCause getCause() {
        return this.cause;
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
        return GamePlayerDamageEvent.HANDLERS;
    }

}
