package com.slyvr.api.event.player;

import com.slyvr.api.entity.GameEntity;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class GamePlayerDeathByGameEntityEvent extends GamePlayerDeathEvent {

    private final GameEntity entity;

    public GamePlayerDeathByGameEntityEvent(GamePlayer player, GameEntity entity, DamageCause cause, String message) {
        super(player, cause, message);

        this.entity = entity;
    }

    public GameEntity getKiller() {
        return this.entity;
    }

    public GamePlayer getOwner() {
        return hasOwner() ? this.entity.getOwner() : null;
    }

    public boolean hasOwner() {
        return this.entity.getOwner() != null;
    }

}