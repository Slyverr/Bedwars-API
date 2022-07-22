package com.slyvr.api.event.generator;

import com.slyvr.api.generator.ItemGenerator;
import org.bukkit.event.HandlerList;

public class GeneratorUpgradeEvent extends GeneratorEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private String upgradeMessage;

    public GeneratorUpgradeEvent(ItemGenerator generator, String upgradeMessage) {
        super(generator);

        this.upgradeMessage = upgradeMessage;
    }

    public static HandlerList getHandlerList() {
        return GeneratorUpgradeEvent.HANDLERS;
    }

    public String getUpgradeMessage() {
        return this.upgradeMessage;
    }

    public void setUpgradeMessage(String message) {
        this.upgradeMessage = message;
    }

    @Override
    public HandlerList getHandlers() {
        return GeneratorUpgradeEvent.HANDLERS;
    }

}
