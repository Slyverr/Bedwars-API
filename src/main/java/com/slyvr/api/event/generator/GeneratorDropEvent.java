package com.slyvr.api.event.generator;

import com.slyvr.api.generator.ItemGenerator;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GeneratorDropEvent extends GeneratorEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public GeneratorDropEvent(ItemGenerator gen) {
        super(gen);
    }

    public static HandlerList getHandlerList() {
        return GeneratorDropEvent.HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return GeneratorDropEvent.HANDLERS;
    }

}