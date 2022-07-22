package com.slyvr.api.event.tnt;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Event;

public abstract class TNTEvent extends Event {

    private final GamePlayer owner;
    private final TNTPrimed tnt;

    public TNTEvent(GamePlayer owner, TNTPrimed tnt) {

        this.owner = owner;
        this.tnt = tnt;
    }

    public GamePlayer getOwner() {
        return this.owner;
    }

    public TNTPrimed getTNT() {
        return this.tnt;
    }

}