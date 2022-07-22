package com.slyvr.api.scoreboard.lobby;

import java.util.HashMap;
import java.util.Map;

public enum LobbyBoardLineType {

    STATISTIC,
    PROGRESS,
    PROGRESS_BAR,
    LEVEL,
    EMPTY,
    COINS,
    TEXT,
    DATE;

    private static final Map<String, LobbyBoardLineType> BY_NAME = new HashMap<>(9);

    static {
        for (LobbyBoardLineType type : values())
            LobbyBoardLineType.BY_NAME.put(type.name().toLowerCase(), type);

        BY_NAME.put("progress bar", PROGRESS_BAR);
    }

    public static LobbyBoardLineType fromString(String type) {
        return type != null ? BY_NAME.get(type.toLowerCase()) : null;
    }

}
