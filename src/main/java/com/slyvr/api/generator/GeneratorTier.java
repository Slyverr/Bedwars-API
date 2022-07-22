package com.slyvr.api.generator;

import com.google.common.base.Preconditions;

public class GeneratorTier {

    private final String name;

    private final int time;
    private int limit;

    public GeneratorTier(String name, int time, int limit) {
        Preconditions.checkNotNull(name, "Tier display name cannot be null");

        this.name = name;
        this.time = time;
        this.limit = limit;
    }

    /**
     * Gets display name of this tier
     *
     * @return display name of this tier
     */
    public String getDisplayName() {
        return this.name;
    }

    /**
     * Gets drop time in seconds
     *
     * @return drop time in seconds
     */
    public int getDropTime() {
        return this.time;
    }

    public int getDropLimit() {
        return this.limit;
    }

    public void setDropLimit(int limit) {
        if (limit > 0)
            this.limit = limit;
    }

}