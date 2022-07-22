package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDeathByGamePlayerEvent extends GamePlayerDeathEvent {

    private final GamePlayer killer;

    public GamePlayerDeathByGamePlayerEvent(GamePlayer player, GamePlayer killer, DamageCause cause, String message) {
        super(player, cause, message);

        this.killer = killer;
    }

    public GamePlayer getKiller() {
        return this.killer;
    }

}