package com.slyvr.api.entity;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.team.Team;
import org.bukkit.entity.Entity;

public interface GameEntity {

    /**
     * Gets game of this entity
     *
     * @return game of the entity
     */
    Game getGame();

    /**
     * Gets the team of this entity
     *
     * @return team of the entity
     */
    Team getGameTeam();

    /**
     * Gets the player who spawned this entity
     *
     * @return The player who spawned the entity
     */
    GamePlayer getOwner();

    /**
     *
     */
    GameEntityType getGameEntityType();

    /**
     *
     */
    Entity getEntity();

    /**
     * Spawns this entity
     *
     * @return the spawned entity
     */
    Entity spawn();

    /**
     * Removes this entity
     */
    void remove();

    /**
     * Checks if this entity has spawned
     *
     * @return {@code true} if the entity has spawned, otherwise false
     */
    boolean hasSpawned();

}