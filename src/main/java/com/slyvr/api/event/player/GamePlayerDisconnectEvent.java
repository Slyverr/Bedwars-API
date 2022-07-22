package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.HandlerList;

public class GamePlayerDisconnectEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private String message;

    public GamePlayerDisconnectEvent(GamePlayer player, String message) {
        super(player);

        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerDisconnectEvent.HANDLERS;
    }

    public String getDisconnectMessage() {
        return this.message;
    }

    public void setDisconnectMessage(String msg) {
        if (msg != null)
            this.message = msg;
    }

    @Override
    public HandlerList getHandlers() {
        return GamePlayerDisconnectEvent.HANDLERS;
    }

}