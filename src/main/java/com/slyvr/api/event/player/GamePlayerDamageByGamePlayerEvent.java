package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDamageByGamePlayerEvent extends GamePlayerDamageEvent {

    private final GamePlayer damager;

    public GamePlayerDamageByGamePlayerEvent(GamePlayer player, GamePlayer damager, DamageCause cause) {
        super(player, cause);

        this.damager = damager;
    }

    public GamePlayer getDamager() {
        return this.damager;
    }

}