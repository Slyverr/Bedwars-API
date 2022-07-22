package com.slyvr.api.entity;

import java.util.HashMap;
import java.util.Map;

public enum GameEntityType {

    BED_BUG("Bed Bug"),
    BODY_GUARD("Body Guard"),
    DRAGON("Dragon"),
    CUSTOM("Custom");

    private static final Map<String, GameEntityType> BY_NAME = new HashMap<>();

    static {
        for (GameEntityType type : values())
            GameEntityType.BY_NAME.put(type.type.toLowerCase(), type);
    }

    private final String type;

    GameEntityType(String type) {

        this.type = type;
    }

    public static GameEntityType getByName(String name) {
        return name != null ? GameEntityType.BY_NAME.get(name.toLowerCase()) : null;
    }

}
