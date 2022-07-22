package com.slyvr.api.team;

import com.slyvr.api.game.Game;
import com.slyvr.api.trap.TrapManager;
import com.slyvr.api.upgrade.UpgradeManager;

public interface GameTeam {

    /**
     * Gets game of this team
     *
     * @return game of this team;
     */
    Game getGame();

    /**
     * Gets team representing this team
     *
     * @return team of this game team
     */
    Team getTeam();

    /**
     * Gets team upgrade manager
     *
     * @return upgrade manager of this team
     */
    UpgradeManager getUpgradeManager();

    /**
     *
     */
    TrapManager getTrapManager();

}