package com.slyvr.api.user;

import com.slyvr.api.game.Game;
import com.slyvr.api.game.GameMode;
import com.slyvr.api.level.BedwarsLevel;
import com.slyvr.api.prestige.Prestige;
import com.slyvr.api.scoreboard.lobby.LobbyScoreboard;
import com.slyvr.api.shop.QuickBuy;
import org.bukkit.entity.Player;

public interface User {

    /**
     * Gets the player representing this user
     */
    Player getPlayer();

    /**
     * Gets the game this player is currently playing on if exists
     *
     * @return game if exists, otherwise false
     */
    Game getGame();

    /**
     *
     */
    BedwarsLevel getLevel();

    /**
     *
     */
    void setLevel(BedwarsLevel level);

    /**
     * Gets the display level of this user
     *
     * @return display level if exists, otherwise null
     */
    BedwarsLevel getDisplayLevel();

    /**
     * Sets the display level of this user
     *
     * @param level Level to display
     */
    void setDisplayLevel(BedwarsLevel level);

    /**
     *
     */
    Prestige getPrestige();

    /**
     *
     */
    void setPrestige(Prestige prestige);

    /**
     *
     */
    Prestige getDisplayPrestige();

    /**
     *
     */
    void setDisplayPrestige(Prestige prestige);

    /**
     *
     */
    UserStatistics getStatistics(GameMode mode);

    /**
     *
     */
    UserStatistics getOverallStatistics();

    /**
     * Gets coins balance
     *
     * @return balance
     */
    int getCoinsBalance();

    /**
     * Sets coins balance
     *
     * @param balance The new balance
     */
    void setCoinsBalance(int balance);

    /**
     * Gets player scoreboard
     *
     * @return Player scoreboard
     */
    LobbyScoreboard getScoreboard();

    /**
     * Sets player scoreboard
     *
     * @param board The new scoreboard
     */
    void setScoreboard(LobbyScoreboard board);

    /**
     *
     */
    QuickBuy getQuickBuy(GameMode mode);

    /**
     * Updates player scoreboard
     */
    void updateScoreboard();

    /**
     * Loads player data from user file
     */
    void loadData();

    /**
     * Saves player data to user file
     */
    void saveData();

}