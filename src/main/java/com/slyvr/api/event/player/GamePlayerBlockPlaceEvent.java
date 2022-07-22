package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GamePlayerBlockPlaceEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Block block;

    private boolean isCancelled;

    public GamePlayerBlockPlaceEvent(GamePlayer player, Block block) {
        super(player);

        this.block = block;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerBlockPlaceEvent.HANDLERS;
    }

    public Block getBlock() {
        return this.block;
    }

    public Material getType() {
        return this.block.getType();
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return GamePlayerBlockPlaceEvent.HANDLERS;
    }

}
