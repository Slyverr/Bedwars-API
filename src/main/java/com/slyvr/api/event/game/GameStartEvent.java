package com.slyvr.api.event.game;

import com.slyvr.api.game.Game;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.Set;
import java.util.UUID;

public class GameStartEvent extends GameEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Set<UUID> players;
    private final Set<UUID> spectators;
    private boolean isCancelled;

    public GameStartEvent(Game game, Set<UUID> players, Set<UUID> spectators) {
        super(game);

        this.players = players;
        this.spectators = spectators;
    }

    public static HandlerList getHandlerList() {
        return GameStartEvent.HANDLERS;
    }

    public Set<UUID> getPlayers() {
        return this.players;
    }

    public Set<UUID> getSpectators() {
        return this.spectators;
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
        return GameStartEvent.HANDLERS;
    }

}
