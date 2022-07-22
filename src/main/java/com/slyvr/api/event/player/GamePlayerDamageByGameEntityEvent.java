package com.slyvr.api.event.player;

import com.slyvr.api.entity.GameEntity;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDamageByGameEntityEvent extends GamePlayerDamageEvent {

    private final GameEntity damager;

    public GamePlayerDamageByGameEntityEvent(GamePlayer player, GameEntity entity, DamageCause cause) {
        super(player, cause);

        this.damager = entity;
    }

    public GameEntity getDamager() {
        return this.damager;
    }

}