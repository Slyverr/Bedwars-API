package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class AsyncGamePlayerChatEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private String format = "%1$s%2$s §r%3$s§r: %4$s";
    private final String message;

    private boolean isCancelled;

    public AsyncGamePlayerChatEvent(GamePlayer player, String message) {
        super(player, true);

        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return AsyncGamePlayerChatEvent.HANDLERS;
    }

    public String getMessage() {
        return this.message;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
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
        return AsyncGamePlayerChatEvent.HANDLERS;
    }

}