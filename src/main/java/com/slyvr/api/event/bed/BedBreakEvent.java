package com.slyvr.api.event.bed;

import com.slyvr.api.arena.BedwarsBed;
import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BedBreakEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer gamePlayer;
    private final BedwarsBed bed;
    private String message;

    private boolean isCancelled;

    public BedBreakEvent(GamePlayer player, BedwarsBed bed, String breakMessage) {

        this.gamePlayer = player;
        this.bed = bed;
        this.message = breakMessage;
    }

    public static HandlerList getHandlerList() {
        return BedBreakEvent.HANDLERS;
    }

    /**
     * Returns The {@code GamePlayer} who broke the bed
     *
     * @return The {@code GamePlayer} who broke the bed
     */
    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    /**
     * Gets destroyed Bed.
     *
     * @return destroyed Bed.
     */
    public BedwarsBed getBed() {
        return this.bed;
    }

    /**
     * Get Bed Destruction Message
     *
     * @return Bed Destruction Message
     */
    public String getBreakMessage() {
        return this.message;
    }

    /**
     * Sets Bed Destruction Message
     */
    public void setBreakMessage(String message) {
        this.message = message;
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
        return BedBreakEvent.HANDLERS;
    }

}