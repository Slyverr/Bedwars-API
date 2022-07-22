package com.slyvr.api.bedwars;

import com.slyvr.api.arena.Arena;
import com.slyvr.api.entity.GameEntityManager;
import com.slyvr.api.game.Game;
import com.slyvr.api.game.GameMode;
import com.slyvr.api.game.GamePhase;
import com.slyvr.api.npc.NPCManager;
import com.slyvr.api.prestige.Prestige;
import com.slyvr.api.scoreboard.lobby.LobbyScoreboard;
import com.slyvr.api.shop.Shop;
import com.slyvr.api.upgrade.shop.UpgradeShop;
import com.slyvr.api.user.User;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface BedwarsPlugin extends Plugin {

    /**
     * Gets plugin prefix
     *
     * @return plugin prefix
     */
    String getPluginPrefix();

    /**
     * Gets default prestige
     *
     * @return Default prestige
     */
    Prestige getDefaultPrestige();

    /**
     * Gets lobby scoreboard
     *
     * @return Lobby scoreboard
     */
    LobbyScoreboard getLobbyScoreboard();

    /**
     * Gets GamePhase by its name
     *
     * @param name GamePhase name
     *
     * @return GamePhase if found, otherwise null
     */
    GamePhase getGamePhase(String name);

    /**
     * Registers GamePhase
     *
     * @param phase GamePhase to register
     */
    void registerGamePhase(GamePhase phase);

    /**
     * Gets NPCManager
     *
     * @return NPCManager
     */
    NPCManager getNPCManager();

    /**
     * Gets GameEntityManager
     *
     * @return GameEntityManager
     */
    GameEntityManager getEntityManager();

    /**
     * Gets ItemShop for the specified mode
     *
     * @param mode Shop mode
     *
     * @return ItemShop if exists, otherwise null
     */
    Shop getTeamShop(GameMode mode);

    /**
     * Gets UpgradeShop for the specified mode
     *
     * @param mode Shop mode
     *
     * @return UpgradeShop if exists, otherwise null
     */
    UpgradeShop getTeamUpgradeShop(GameMode mode);

    /**
     * Gets Upgrade manager
     *
     * @return Upgrade manager
     */
    UpgradesManager getUpgradesManager();

    /**
     * Loads user
     *
     * @param player User's owner
     *
     * @return User if loaded, otherwise null
     */
    User loadUser(Player player);

    /**
     * Gets user if loaded
     *
     * @param player User's owner
     *
     * @return User if found, otherwise null
     */
    User getUser(Player player);

    /**
     * Gets arena with the specified name
     *
     * @param name Arena's name
     *
     * @return Arena if found, otherwise null
     */
    Arena getArena(String name);

    /**
     * Tries to add player to random game if found
     *
     * @param player Player to add
     * @param mode   Game mode or null for random mode
     *
     * @return Game if found, otherwise null
     */
    Game addPlayerToRandomGame(Player player, GameMode mode);

    /**
     * Tries to add player to random game with a random game mode if found
     *
     * @param player Player to add
     *
     * @return Game if found, otherwise null
     */
    Game addPlayerToRandomGame(Player player);

    /**
     * Gets a random game with specific mode
     *
     * @return Random game or null if none found
     */
    Game getRandomGame(GameMode mode);

    /**
     * Gets a random game with random mode
     *
     * @return Random game or null if none found
     */
    Game getRandomGame();

    /**
     * Gets player current game
     *
     * @param player Player to check
     *
     * @return Player's game if found, otherwise null
     */
    Game getPlayerGame(Player player);

    /**
     * Checks if player is in a game
     *
     * @param player Player to check
     *
     * @return true if player in a game, otherwise false
     */
    boolean inGame(Player player);

    /**
     * Checks if player is in a started game
     *
     * @param player Player to check
     *
     * @return true if player in a started game, otherwise false
     */
    boolean inRunningGame(Player player);

    /**
     * Send player to lobby if possible or kicking them
     *
     * @param game   The game this player was in
     * @param player The player to send back to lobby
     *
     * @return true if player was sent to lobby or kicked, otherwise false
     */
    boolean sendPlayerToLobby(Game game, Player player, String message);

}
