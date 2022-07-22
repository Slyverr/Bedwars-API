package com.slyvr.api.event.trap;

import com.slyvr.api.trap.Trap;
import org.bukkit.event.Event;

public abstract class TrapEvent extends Event {

    private final Trap trap;

    public TrapEvent(Trap trap) {
        this.trap = trap;
    }

    public final Trap getTrap() {
        return this.trap;
    }

}
