package com.slyvr.api.arena;

import com.google.common.base.Preconditions;
import com.slyvr.api.team.Team;
import org.bukkit.block.Block;

public final class BedwarsBed {

    private final Team team;
    private final Block head;
    private final Block foot;

    public BedwarsBed(Team team, Block head, Block foot) {
        Preconditions.checkNotNull(team, "Bed team cannot be null!");
        Preconditions.checkNotNull(head, "Bed head cannot be null!");
        Preconditions.checkNotNull(foot, "Bed foot cannot be null!");

        this.team = team;
        this.head = head;
        this.foot = foot;
    }

    public Team getTeam() {
        return this.team;
    }

    public Block getHead() {
        return this.head;
    }

    public Block getFoot() {
        return this.foot;
    }

}