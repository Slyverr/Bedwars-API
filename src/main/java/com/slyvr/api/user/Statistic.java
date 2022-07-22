package com.slyvr.api.user;

import java.util.HashMap;
import java.util.Map;

public enum Statistic {

    GAME_PLAYED("Game Played"),

    BED_BROKEN("Bed Broken"),
    BED_LOSSES("Bed Losses"),

    KILLS("Kills"),
    DEATHS("Deaths"),

    FINAL_KILLS("Final Kills"),
    FINAL_DEATHS("Final Deaths"),

    WINS("Wins"),
    LOSSES("Losses"),

    WINSTREAK("Winstreak");

    private static final Map<String, Statistic> BY_NAME = new HashMap<>();

    static {
        for (Statistic stat : values()) {
            BY_NAME.put(stat.name().toLowerCase(), stat);
            BY_NAME.put(stat.name.toLowerCase(), stat);

        }

    }

    private final String name;

    Statistic(String name) {
        this.name = name;
    }

    public static Statistic getByName(String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

    @Override
    public String toString() {
        return this.name;
    }

}