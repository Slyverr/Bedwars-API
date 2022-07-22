package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GamePlayerReconnectEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private String message;
    private boolean isCancelled;

    public GamePlayerReconnectEvent(GamePlayer player, String message) {
        super(player);

        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerReconnectEvent.HANDLERS;
    }

    public String getReconnectMessage() {
        return this.message;
    }

    public void setReconnectMessage(String msg) {
        if (msg != null)
            this.message = msg;
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
        return GamePlayerReconnectEvent.HANDLERS;
    }

}