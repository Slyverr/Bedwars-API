package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDeathEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final DamageCause cause;
    private String message;

    public GamePlayerDeathEvent(GamePlayer player, DamageCause cause, String message) {
        super(player);

        this.cause = cause;
        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerDeathEvent.HANDLERS;
    }

    public DamageCause getCause() {
        return this.cause;
    }

    public String getDeathMessage() {
        return this.message;
    }

    public void setDeathMessage(String message) {
        if (message != null)
            this.message = message;
    }

    @Override
    public HandlerList getHandlers() {
        return GamePlayerDeathEvent.HANDLERS;
    }

}