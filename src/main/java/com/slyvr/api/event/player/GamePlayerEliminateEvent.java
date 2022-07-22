package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.HandlerList;

public class GamePlayerEliminateEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public GamePlayerEliminateEvent(GamePlayer player) {
        super(player);

    }

    public static HandlerList getHandlerList() {
        return GamePlayerEliminateEvent.HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return GamePlayerEliminateEvent.HANDLERS;
    }
}
