package com.slyvr.api.entity;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.team.Team;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface GameEntityManager {

    BedBug createBedBug(Game game, Team team, GamePlayer owner, Location loc);

    BedBug getBedBug(Entity entity);

    boolean isBedBug(Entity entity);

    BodyGuard createBodyGuard(Game game, Team team, GamePlayer owner, Location loc);

    BodyGuard getBodyGuard(Entity entity);

    boolean isBodyGuard(Entity entity);

    Dragon createDragon(Game game, Team team, GamePlayer owner, Location loc);

    Dragon getDragon(Entity entity);

    boolean isDragon(Entity entity);

    GameEntity getGameEntity(Entity entity);

    boolean isGameEntity(Entity entity);

}
