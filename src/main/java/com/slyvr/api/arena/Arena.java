package com.slyvr.api.arena;

import com.slyvr.api.game.GameMode;
import com.slyvr.api.generator.GeneratorSpeed;
import com.slyvr.api.generator.Resource;
import com.slyvr.api.team.Team;
import org.bukkit.Location;
import org.bukkit.block.Chest;

import java.util.List;
import java.util.Set;

/**
 * Represents an arena
 */
public interface Arena {

    /**
     *
     */
    String getName();

    /**
     *
     */
    String getMapName();

    /**
     *
     */
    void setMapName(String name);

    /**
     *
     */
    int getTime();

    /**
     *
     */
    GameMode getMode();

    /**
     *
     */
    void setMode(GameMode mode);

    /**
     *
     */
    Set<Team> getTeams();

    /**
     *
     */
    List<Location> getResourceGenLocations(Resource resource);

    /**
     *
     */
    GeneratorSpeed getGeneratorSpeed();

    /*
     * */
    void setGeneratorSpeed(GeneratorSpeed speed);

    /**
     *
     */
    Location getTeamShop(Team team);

    /**
     *
     */
    Location getTeamUpgrade(Team team);

    /**
     *
     */
    Location getTeamGenLocation(Team team);

    /**
     *
     */
    Location getTeamSpawnPoint(Team team);

    /**
     *
     */
    BedwarsBed getTeamBed(Team team);

    /**
     *
     */
    Chest getTeamChest(Team team);

    /**
     *
     */
    Location getDragonSpawnPoint();

    /**
     *
     */
    void setDragonSpawnPoint(Location loc);

    /**
     *
     */
    Location getLobbySpawnPoint();

    /***/
    void setLobbySpawnPoint(Location loc);

    /**
     *
     */
    Location getSpectatorSpawnPoint();

    /**
     *
     */
    void setSpectatorSpawnPoint(Location loc);

    /**
     *
     */
    Location getWaitingRoomSpawnPoint();

    /***/
    Region getWaitingRoomRegion();

    /***/
    void setWaitingRoomRegion(Region region);

    /**
     *
     */
    Region getRegion();

    /**
     *
     */
    void setArenaTime(int time);

    /**
     *
     */
    void setTeamShop(Team team, Location loc);

    /**
     *
     */
    void setTeamUpgrade(Team team, Location loc);

    /**
     *
     */
    void addResourceGenerator(Resource resource, Location loc);

    /**
     *
     */
    boolean removeResourceGenerator(Resource resource, int index);

    /**
     *
     */
    void setTeamGenLocation(Team team, Location loc);

    /**
     *
     */
    void setTeamSpawnPoint(Team team, Location loc);

    /**
     *
     */
    void setTeamBed(BedwarsBed bed);

    /**
     *
     */
    void setTeamChest(Team team, Chest chest);

    /**
     *
     */
    void setWaitingRoomLocation(Location loc);

    /**
     *
     */
    void setArenaRegion(Region region);

    /**
     * Reloads The {@code Arena}.
     */
    void reloadArena();

    /**
     *
     */
    void saveArena();

    /**
     *
     */
    boolean exists();

    /**
     *
     */
    boolean remove();

    /**
     * Checks if the arena is enabled or not
     *
     * @return {@code true} if the arena is enabled, otherwise false
     */
    boolean isEnabled();

    /**
     *
     */
    void setEnabled(boolean enabled);

    /**
     *
     */
    boolean isReady();

}