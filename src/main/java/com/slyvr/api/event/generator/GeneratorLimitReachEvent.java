package com.slyvr.api.event.generator;

import com.slyvr.api.generator.ItemGenerator;
import org.bukkit.event.HandlerList;

public class GeneratorLimitReachEvent extends GeneratorEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public GeneratorLimitReachEvent(ItemGenerator generator) {
        super(generator);
    }

    public static HandlerList getHandlerList() {
        return GeneratorLimitReachEvent.HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return GeneratorLimitReachEvent.HANDLERS;
    }

}