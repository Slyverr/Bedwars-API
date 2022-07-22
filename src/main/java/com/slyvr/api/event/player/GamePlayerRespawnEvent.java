package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.HandlerList;

public class GamePlayerRespawnEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private String message;

    public GamePlayerRespawnEvent(GamePlayer player, String respawnMessage) {
        super(player);

        this.message = respawnMessage;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerRespawnEvent.HANDLERS;
    }

    public String getRespawnMessage() {
        return this.message;
    }

    public void setRespawnMessage(String message) {
        this.message = message;
    }

    @Override
    public HandlerList getHandlers() {
        return GamePlayerRespawnEvent.HANDLERS;
    }

}