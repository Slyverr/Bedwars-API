package com.slyvr.api.npc;

import org.bukkit.Location;

public interface NPC {

    void spawn();

    void remove();

    void teleport(Location location);

}
