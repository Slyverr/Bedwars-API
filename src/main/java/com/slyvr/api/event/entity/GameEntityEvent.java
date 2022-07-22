package com.slyvr.api.event.entity;

import com.slyvr.api.entity.GameEntity;
import org.bukkit.event.Event;

public abstract class GameEntityEvent extends Event {

    private final GameEntity entity;

    public GameEntityEvent(GameEntity entity) {

        this.entity = entity;
    }

    public final GameEntity getEntity() {
        return this.entity;
    }

}
