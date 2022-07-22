package com.slyvr.api.trap;

import java.util.List;

public interface TrapManager {

    List<Trap> getTraps();

    void addTrap(Trap trap);

    void removeTrap(Trap trap);

    boolean contains(Trap trap);

}