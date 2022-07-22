package com.slyvr.api.game;


import java.util.HashMap;
import java.util.Map;

public enum GameStatistic {

    KILLS("Kills"),
    DEATHS("Deaths"),

    FINAL_KILLS("Final Kills"),
    FINAL_DEATHS("Final Deaths"),

    BED_BROKEN("Bed Broken"),
    BED_LOST("Bed Lost");

    private static final Map<String, GameStatistic> BY_NAME = new HashMap<>();

    static {
        for (GameStatistic stat : GameStatistic.values())
            GameStatistic.BY_NAME.put(stat.toString().toLowerCase(), stat);
    }

    private final String name;

    GameStatistic(String name) {
        this.name = name;
    }

    public static GameStatistic fromString(String string) {
        return string != null ? GameStatistic.BY_NAME.get(string.toLowerCase()) : null;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
