package com.slyvr.api.event.team;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.team.Team;
import org.bukkit.event.Event;

import java.util.Collection;

public abstract class TeamEvent extends Event {

    protected Game game;
    protected Team team;

    protected Collection<GamePlayer> teamPlayers;

    public TeamEvent(Game game, Team team) {

        this.game = game;
        this.team = team;
    }

    public final Game getGame() {
        return this.game;
    }

    public final Team getTeam() {
        return this.team;
    }

}