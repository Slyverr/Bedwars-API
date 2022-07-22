package com.slyvr.api.event.game;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.GameState;
import org.bukkit.event.HandlerList;

public class GameStateChangeEvent extends GameEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GameState oldState;
    private final GameState newState;

    public GameStateChangeEvent(Game game, GameState oldState, GameState newState) {
        super(game);

        this.oldState = oldState;
        this.newState = newState;
    }

    public static HandlerList getHandlerList() {
        return GameStateChangeEvent.HANDLERS;
    }

    public GameState getOldState() {
        return this.oldState;
    }

    public GameState getNewState() {
        return this.newState;
    }

    @Override
    public HandlerList getHandlers() {
        return GameStateChangeEvent.HANDLERS;
    }

}