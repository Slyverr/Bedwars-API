package com.slyvr.api.event.tnt;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.Collection;

public class TNTExplodeEvent extends TNTEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Collection<Entity> entities;

    private boolean isCancelled;

    public TNTExplodeEvent(GamePlayer gp, TNTPrimed tnt, Collection<Entity> entities) {
        super(gp, tnt);

        this.entities = entities;
    }

    public static HandlerList getHandlerList() {
        return TNTExplodeEvent.HANDLERS;
    }

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
        return TNTExplodeEvent.HANDLERS;
    }

}