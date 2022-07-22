package com.slyvr.api.generator;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

public class GeneratorSpeed {

    private static final Map<String, GeneratorSpeed> BY_NAME = new HashMap<>();

    private final Map<Resource, Integer> speeds = new HashMap<>();

    private final String name;

    public GeneratorSpeed(String name) {
        Preconditions.checkNotNull(name, "Forge speed name cannot be null");

        this.name = name;
    }

    public static GeneratorSpeed getByName(String name) {
        return name != null ? GeneratorSpeed.BY_NAME.get(name.toLowerCase()) : null;
    }

    public static void registerSpeed(GeneratorSpeed speed) {
        Preconditions.checkNotNull(speed, "Cannot register null speed");

        if (GeneratorSpeed.BY_NAME.containsKey(speed.getName().toLowerCase()))
            throw new IllegalArgumentException("Cannot register existant speed");

        GeneratorSpeed.BY_NAME.put(speed.getName().toLowerCase(), speed);
    }

    public String getName() {
        return this.name;
    }

    public int getDropsPerMinute(Resource rsc) {
        Integer result = this.speeds.get(rsc);
        return result != null ? result : 0;
    }

    public void setDropsPerMinute(Resource rsc, int dropsPerMin) {
        if (hasResource(rsc))
            throw new IllegalStateException("Resource already exists and cannot be changed!");

        this.speeds.put(rsc, dropsPerMin);
    }

    public boolean hasResource(Resource rsc) {
        return rsc != null && this.speeds.containsKey(rsc);
    }

}