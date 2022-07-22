package com.slyvr.api.event.player;

import com.slyvr.api.game.player.GamePlayer;

public class AsyncGamePlayerShoutEvent extends AsyncGamePlayerChatEvent {

    public AsyncGamePlayerShoutEvent(GamePlayer player, String message) {
        super(player, message);

        super.setFormat("%1$s %2$s: %3$s");
    }

}