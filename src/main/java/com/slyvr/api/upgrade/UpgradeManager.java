package com.slyvr.api.upgrade;

import com.slyvr.api.game.player.GamePlayer;

import java.util.Set;
import java.util.function.Predicate;

public interface UpgradeManager {

    Set<Upgrade> getUpgrades();

    Upgrade getUpgrade(String name);

    void add(Upgrade upgrade);

    void remove(Upgrade upgrade);

    boolean contains(Upgrade upgrade);

    void apply(GamePlayer gp);

    void apply(GamePlayer gp, Predicate<Upgrade> predicate);

}