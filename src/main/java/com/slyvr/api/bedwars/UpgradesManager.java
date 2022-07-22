package com.slyvr.api.bedwars;

import com.slyvr.api.trap.Trap;
import com.slyvr.api.upgrade.TieredUpgrade;
import com.slyvr.api.upgrade.Upgrade;

import java.util.HashMap;
import java.util.Map;

public final class UpgradesManager {

    private static UpgradesManager instance;
    private final Map<String, TieredUpgrade> tiered = new HashMap<>();
    private final Map<String, Upgrade> upgrades = new HashMap<>();
    private final Map<String, Trap> traps = new HashMap<>();

    private UpgradesManager() {
    }

    public static UpgradesManager getInstance() {
        if (instance == null)
            UpgradesManager.instance = new UpgradesManager();

        return UpgradesManager.instance;
    }

    public Upgrade getUpgrade(String name) {
        return name != null ? this.upgrades.get(name.toLowerCase()) : null;
    }

    public void registerUpgrade(String name, Upgrade upgrade) {
        register(this.upgrades, name, upgrade);
    }

    public TieredUpgrade getTieredUpgrade(String name) {
        if (name == null)
            return null;

        TieredUpgrade upgrade = this.tiered.get(name.toLowerCase());
        return upgrade != null ? upgrade.clone() : null;
    }

    public void registerTieredUpgrade(String name, TieredUpgrade upgrade) {
        register(this.tiered, name, upgrade);
    }

    public Trap getTrapUpgrade(String name) {
        return name != null ? this.traps.get(name.toLowerCase()) : null;
    }

    public void registerTrapUpgrade(String name, Trap trap) {
        register(this.traps, name, trap);
    }

    private <V> void register(Map<String, V> map, String key, V value) {
        if (key == null || value == null)
            return;

        if (this.traps.containsKey(key.toLowerCase()))
            throw new IllegalStateException("TrapUpgrade is already registered");

        map.put(key.toLowerCase(), value);
    }

}