package com.slyvr.api.event.game;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.HandlerList;

import java.util.List;

public class GameEndEvent extends GameEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final List<GamePlayer> winners;
    private final List<GamePlayer> losers;

    public GameEndEvent(Game game, List<GamePlayer> winners, List<GamePlayer> losers) {
        super(game);

        this.winners = winners;
        this.losers = losers;
    }

    public static HandlerList getHandlerList() {
        return GameEndEvent.HANDLERS;
    }

    public List<GamePlayer> getWinners() {
        return this.winners;
    }

    public List<GamePlayer> getLosers() {
        return this.losers;
    }

    @Override
    public HandlerList getHandlers() {
        return GameEndEvent.HANDLERS;
    }

}