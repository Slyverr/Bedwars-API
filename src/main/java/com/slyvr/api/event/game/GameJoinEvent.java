package com.slyvr.api.event.game;

import com.slyvr.api.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GameJoinEvent extends GameEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private String message;

    private boolean isCancelled;

    public GameJoinEvent(Game game, Player player, String message) {
        super(game);

        this.player = player;
        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return GameJoinEvent.HANDLERS;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getJoinMessage() {
        return this.message;
    }

    public void setJoinMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return GameJoinEvent.HANDLERS;
    }

}