package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GamePlayerBlockBreakEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Block block;

    private boolean isCancelled;

    public GamePlayerBlockBreakEvent(GamePlayer player, Block block) {
        super(player);

        this.block = block;
    }

    public static HandlerList getHandlerList() {
        return GamePlayerBlockBreakEvent.HANDLERS;
    }

    public Block getBlock() {
        return this.block;
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
        return GamePlayerBlockBreakEvent.HANDLERS;
    }

}
