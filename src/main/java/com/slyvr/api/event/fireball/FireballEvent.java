package com.slyvr.api.event.fireball;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.Fireball;
import org.bukkit.event.Event;

public abstract class FireballEvent extends Event {

    private final GamePlayer owner;
    private final Fireball fireball;

    public FireballEvent(GamePlayer owner, Fireball fireball) {

        this.owner = owner;
        this.fireball = fireball;
    }

    public final GamePlayer getOwner() {
        return this.owner;
    }

    public final Fireball getFireball() {
        return this.fireball;
    }

}
