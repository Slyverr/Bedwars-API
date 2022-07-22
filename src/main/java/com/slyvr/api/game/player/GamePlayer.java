package com.slyvr.api.game.player;

import com.slyvr.api.game.Game;
import com.slyvr.api.team.Team;
import org.bukkit.entity.Player;

public interface GamePlayer {

    /**
     * Gets Player representing this GamePlayer
     *
     * @return Player representing this GamePlayer
     */
    Player getPlayer();

    /**
     * Gets Game of this player
     *
     * @return Game of this player
     */
    Game getGame();

    /**
     *
     */
    Team getTeam();

    /**
     * Gets {@code ArmorType} of this player
     *
     * @return {@code ArmorType} of this player
     */
    ArmorType getArmorType();

    /**
     * Sets {@code ArmorType} of this player
     *
     * @param type new {@code ArmorType}
     */
    void setArmorType(ArmorType type);

    /**
     * Gets player inventory
     *
     * @return player inventory
     */
    GameInventory getInventory();

    /**
     *
     */
    void setInventory(GameInventory inv);

    /**
     *
     */
    GameStatisticManager getStatisticManager();

    /**
     *
     */
    void setStatistics(GameStatisticManager statistics);

}