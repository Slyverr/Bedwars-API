package com.slyvr.api.trap;

import com.slyvr.api.game.player.GamePlayer;
import com.slyvr.api.team.Team;

public interface Trap {

    /**
     * Gets the name of this trap
     *
     * @return Name of this trap
     */
    String getName();

    /**
     * Gets the target of this trap
     *
     * @return Target of the trap
     */
    TrapTarget getTarget();

    /**
     * Gets how long this trap effect will last.
     *
     * @return Trap's duration (in seconds)
     */
    int getDuration();

    /**
     * Called when a player enters an enemy team base.
     *
     * @param gp   GamePlayer who entered the base.
     * @param team Trap's team
     *
     * @return true if trap was successfully triggered, otherwise false
     */
    boolean onTrigger(GamePlayer gp, Team team);

}