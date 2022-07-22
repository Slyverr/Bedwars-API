package com.slyvr.api.event.fireball;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.Collection;

public class FireballExplodeEvent extends FireballEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Collection<Entity> entities;

    private boolean isCancelled;

    public FireballExplodeEvent(GamePlayer owner, Fireball fireball, Collection<Entity> entities) {
        super(owner, fireball);

        this.entities = entities;
    }

    public static HandlerList getHandlerList() {
        return FireballExplodeEvent.HANDLERS;
    }

    /**
     * Gets the entities damaged and took knockback
     */
    public Collection<Entity> entities() {
        return this.entities;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return FireballExplodeEvent.HANDLERS;
    }

}