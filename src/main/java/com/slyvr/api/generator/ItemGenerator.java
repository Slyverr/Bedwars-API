package com.slyvr.api.generator;

import org.bukkit.Location;

public interface ItemGenerator {

    /**
     * Gets the drop location of this generator
     *
     * @return drop location of this generator
     */
    Location getDropLocation();

    /**
     * Sets the drop location of this generator
     *
     * @param loc The new location
     */
    void setDropLocation(Location loc);

    /**
     * Starts the generator
     */
    void start();

    /**
     * Stops the generator
     */
    void stop();

    /**
     * Checks if this generator has started or not
     *
     * @return {@code true} if the generator is dropping resource, otherwise false
     */
    boolean isDropping();

}