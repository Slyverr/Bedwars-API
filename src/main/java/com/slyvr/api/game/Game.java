package com.slyvr.api.game;

import com.slyvr.api.arena.Arena;
import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.generator.Resource;
import com.slyvr.api.generator.TeamGenerator;
import com.slyvr.api.generator.TieredGenerator;
import com.slyvr.api.group.Group;
import com.slyvr.api.team.GameTeam;
import com.slyvr.api.team.Team;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Represents a game
 */
public interface Game {

    /**
     * Gets the arena of this game
     *
     * @return Arena of this game
     */
    Arena getArena();

    /**
     * Starts the game
     *
     * @return true if the game was successfully started, otherwise false
     */
    boolean startGame();

    /**
     * Stops the game
     *
     * @return true if the game has been stopped, otherwise false
     */
    boolean stopGame();

    /**
     * Adds the player to the game
     *
     * @param player the player to add
     *
     * @return true if the player has been added to the game, otherwise false
     */
    boolean addPlayer(Player player);

    /**
     * Checks if the player can join this game
     *
     * @param player Player to check
     *
     * @return true if the player can join, otherwise false
     */
    boolean canAddPlayer(Player player);

    /**
     * Removes the player from the game
     *
     * @param player the player to remove
     *
     * @return true if the player has been removed from the game, otherwise false
     */
    boolean removePlayer(Player player);

    /**
     * Adds the team group to the game
     *
     * @param group the group to add
     *
     * @return true if the group has been added to the game, otherwise false
     */
    boolean addGroup(Group group);

    /**
     * Checks if the group can join this game
     *
     * @param group Group to check
     *
     * @return true if the group can join, otherwise false
     */
    boolean canAddGroup(Group group);

    /**
     * Removes the team group to the game
     *
     * @param group the group to add
     *
     * @return true if the group has been removed from the game, otherwise false
     */
    boolean removeGroup(Group group);

    /**
     * Kills the player and respawn it after the given time
     *
     * @param player  Player to kill
     * @param killer  Killer of the player
     * @param respawn Respawn time (in seconds)
     *
     * @return true if the player was killed, otherwise false
     */
    boolean killPlayer(Player player, String message, int respawn);

    /**
     * Kills the player and respawn it after the default countdown
     * <p>
     * Note: if the player has no bed he will be eliminated!
     * </p>
     *
     * @param player  Player to kill
     * @param message Death message
     *
     * @return true if the player was killed, otherwise false
     */
    boolean killPlayer(Player player, String message);

    /**
     * Kills the player and respawn it after the default countdown
     * <p>
     * Note: if the player has no bed he will be eliminated!
     * </p>
     *
     * @param player Player to kill
     *
     * @return true if the player was killed, otherwise false
     */
    boolean killPlayer(Player player);

    /**
     * Eliminates the player from the game
     *
     * @param player the player to eliminate
     *
     * @return true if the player was eliminated from the game, otherwise false
     */
    boolean eliminatePlayer(Player player);

    /**
     * Checks if the player is eliminated
     *
     * @param player Player to check
     *
     * @return {@code true} if player is eliminated, otherwise false
     */
    boolean isEliminated(Player player);

    /**
     * Eliminates team from the game if exists
     *
     * @param team the team to eliminate
     *
     * @return true if team was successfully eliminated, otherwise false
     */
    boolean eliminateTeam(Team team);

    /**
     * Checks if the team is eliminated or not
     *
     * @param team team to check
     *
     * @return true if the team is eliminated, otherwise false
     */
    boolean isEliminated(Team team);

    /**
     * Breaks team's bed
     *
     * @param team      Bed's team
     * @param destroyer The Player who destroyed the bed or null
     *
     * @return true if the bed was destroyed, otherwise false
     */
    boolean breakTeamBed(Team team, Player destroyer);

    /**
     * Breaks team bed
     *
     * @return {@code true} if the bed was destroyed, otherwise false
     */
    boolean breakTeamBed(Team team);

    /**
     * Checks if the team has a bed or not
     *
     * @return {@code true} if the team has a bed, otherwise false
     */
    boolean hasBed(Team team);

    /**
     * Kicks the player outside the game without removing it from!
     * <p>
     * Note: The player can join back using the {@code reconnect} method
     * </p>
     *
     * @param player the player to disconnect
     *
     * @return true if the player was successfully kicked, otherwise false
     */
    boolean disconnect(Player player);

    /**
     * Checks if the player is disconnected
     *
     * @param player Player to check
     *
     * @return {@code true} if player is disconnected, otherwise false
     */
    boolean isDisconnected(Player player);

    /**
     * Adds the player back to the game if possible
     *
     * @param player the player to reconnect
     *
     * @return true if the player was successfully reconnected, otherwise false
     */
    boolean reconnect(Player player);

    /**
     * Sends a message to all the players in the game
     *
     * @param message The message to send
     *
     * @return {@code true} if the message was sent, otherwise false
     */
    boolean broadcastMessage(String message);

    /**
     * Sends a message whose condition is validate
     * <p>
     * Note: if predicate is null the message will be sent to all players
     * </p>
     *
     * @param message   The message to send
     * @param predicate The condition to test
     *
     * @return true if the message was sent null otherwise
     */
    boolean broadcastMessage(String message, Predicate<Player> predicate);

    /**
     * Gets state of this game
     *
     * @return state of this game
     */
    GameState getGameState();

    /**
     * Sets stats of this game
     *
     * @param state The new state
     */
    void setGameState(GameState state);

    /**
     * Gets mode of this game
     *
     * @return mode of this game
     */
    GameMode getMode();

    /**
     * Gets game manager
     *
     * @return game manager
     */
    GameManager getManager();

    /**
     * Gets {@code GamePlayer} representing this player if exists
     *
     * @param player the player corresponding to the {@code GamePlayer}
     *
     * @return {@code GamePlayer} if exists, otherwise null
     */
    GamePlayer getGamePlayer(Player player);

    /**
     * Checks if the player is invincible or not
     *
     * @param player Player to check
     *
     * @return {@code true} if player is invincible, otherwise false
     */
    boolean isInvincible(Player player);

    /**
     *
     */
    void setInvincible(Player player, boolean invincible);

    /**
     * Checks if the player is a spectator
     *
     * @param player Player to check
     *
     * @return true if player is spectator, otherwise false
     */
    boolean isSpectator(Player player);

    /**
     * Gets team generator
     *
     * @param team Generator's team
     *
     * @return Team generator otherwise null
     */
    TeamGenerator getTeamGenerator(Team team);

    /**
     * Gets Map resource generators
     *
     * @param resource Drops of the generator
     *
     * @return List containing all generators with drop resource
     */
    Collection<TieredGenerator> getMapResourceGenerator(Resource resource);

    /**
     * Gets all players in the game
     *
     * @return all players in the game
     */
    Collection<Player> getPlayers();

    /**
     * Gets a set of players currently playing
     *
     * @return set of players currently playing
     */
    Collection<GamePlayer> getGamePlayers();

    /**
     * Gets players in the team
     *
     * @param team Player's team
     *
     * @return Set of players in the team
     */
    Collection<GamePlayer> getTeamPlayers(Team team);

    /**
     * Gets teams in game
     *
     * @return Set of teams in game
     */
    Collection<GameTeam> getTeams();

    /**
     * Gets {@code GameTeam} representing the team
     *
     * @param team The team to get
     *
     * @return {@code GameTeam} representing the team
     */
    GameTeam getGameTeam(Team team);

    /**
     * Checks if the game has started or not
     *
     * @return true if the game has started, otherwise false
     */
    boolean hasStarted();

    /**
     * Checks if the game is full or not
     *
     * @return true if the game is full, otherwise false
     */
    boolean isFull();

    /**
     * Checks if this game contains the player
     *
     * @param player player to check
     *
     * @return true if the game contains the player, otherwise false
     */
    boolean contains(Player player);

    /**
     * Gets number of players in the game
     *
     * @return number of players
     */
    int size();

}