package com.slyvr.api.npc;

import com.slyvr.api.game.Game;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface NPCManager {

    Shopkeeper createShopKeeper(Game game, Location loc);

    Upgrader createUpgrader(Game game, Location loc);

    Shopkeeper getShopKeeper(Entity entity);

    boolean isShopKeeper(Entity entity);

    Upgrader getUpgrader(Entity entity);

    boolean isUpgrader(Entity entity);

    NPC getNPC(Entity entity);

    boolean isNPC(Entity entity);

}
