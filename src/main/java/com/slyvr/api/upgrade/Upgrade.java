package com.slyvr.api.upgrade;

import com.slyvr.api.game.player.GamePlayer;

public interface Upgrade {

    /**
     * Gets name of this upgrade
     *
     * @return Name of the upgrade
     */
    String getName();

    /**
     * Called when a player purchase this upgrade
     *
     * @param gp GamePlayer who purchased this upgrade
     */
    boolean apply(GamePlayer gp);

}