package com.slyvr.api.event.team;

import com.slyvr.api.game.Game;
import com.slyvr.api.team.Team;
import org.bukkit.event.HandlerList;

public class TeamEliminationEvent extends TeamEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private String message;

    public TeamEliminationEvent(Game game, Team team, String message) {
        super(game, team);

        this.message = message;
    }

    public static HandlerList getHandlerList() {
        return TeamEliminationEvent.HANDLERS;
    }

    public String getEliminationMessage() {
        return this.message;
    }

    public void setEliminationMessage(String message) {
        if (message != null)
            this.message = message;
    }

    @Override
    public HandlerList getHandlers() {
        return TeamEliminationEvent.HANDLERS;
    }

}