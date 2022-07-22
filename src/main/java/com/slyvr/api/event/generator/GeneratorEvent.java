package com.slyvr.api.event.generator;

import com.slyvr.api.generator.ItemGenerator;
import org.bukkit.event.Event;

public abstract class GeneratorEvent extends Event {

    protected ItemGenerator generator;

    public GeneratorEvent(ItemGenerator generator) {

        this.generator = generator;
    }

    public ItemGenerator getGenerator() {
        return this.generator;
    }

}