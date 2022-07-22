package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Event;

public abstract class GamePlayerEvent extends Event {

    protected final GamePlayer player;

    public GamePlayerEvent(GamePlayer player) {
        this.player = player;
    }

    public GamePlayerEvent(GamePlayer player, boolean async) {
        super(async);

        this.player = player;
    }

    public final GamePlayer getGamePlayer() {
        return this.player;
    }

}