package com.slyvr.api.group;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Set;

/**
 * Represents a team group
 */
public interface Group {

    /**
     * Gets a set of all group players
     *
     * @return set of all group players
     */
    Set<Player> getPlayers();

    /**
     * Sets current group players
     *
     * @param players a collection of the new players
     */
    void addPlayers(Collection<Player> players);

    /**
     * Adds the player to the group
     *
     * @param player player to add
     *
     * @return true if the player has been added to the group, otherwise false
     */
    boolean addPlayer(Player player);

    /**
     * Removes player from the group
     *
     * @param player player to remove
     *
     * @return true if the player has been removed from the group, otherwise false
     */
    boolean removePlayer(Player player);

    /**
     * Checks if the group is empty or not
     *
     * @return true if the group is empty otherwise false
     */
    boolean isEmpty();

    /**
     * Checks if the group contain the player
     *
     * @param player player to check
     *
     * @return true if the player exists, otherwise false
     */
    boolean contains(Player player);

    /**
     * Clears the group
     */
    void clear();

    /**
     * Gets the size of this group
     *
     * @return size of this group
     */
    int size();

}
