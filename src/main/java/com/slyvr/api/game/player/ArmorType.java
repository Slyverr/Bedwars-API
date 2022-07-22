package com.slyvr.api.game.player;

import com.slyvr.util.Version;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public enum ArmorType {

    LEATHER("Leather", Material.LEATHER, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS),
    GOLD("Gold", Material.GOLD_INGOT, getGoldenLeggings(), getGoldenBoots()),
    CHAIN("Chain", Material.FIRE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS),
    IRON("Iron", Material.IRON_INGOT, Material.IRON_LEGGINGS, Material.IRON_BOOTS),
    DIAMOND("Diamond", Material.DIAMOND, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);

    private static final Map<Material, ArmorType> BY_CRAFT_TYPE = new HashMap<>(5);
    private static final Map<Material, ArmorType> BY_LEGGINGS = new HashMap<>(5);
    private static final Map<Material, ArmorType> BY_BOOTS = new HashMap<>(5);

    static {
        for (ArmorType type : values()) {
            ArmorType.BY_CRAFT_TYPE.put(type.material, type);
            ArmorType.BY_LEGGINGS.put(type.leggings, type);
            ArmorType.BY_BOOTS.put(type.boots, type);
        }

    }

    private final String type;
    private final Material material;
    private final Material leggings;
    private final Material boots;
    ArmorType(String type, Material material, Material leggings, Material boots) {

        this.type = type;
        this.material = material;
        this.leggings = leggings;
        this.boots = boots;
    }

    private static Material getGoldenLeggings() {
        if (Version.getVersion().isNewAPI())
            return Material.GOLDEN_LEGGINGS;

        return Material.getMaterial("GOLD_LEGGINGS");
    }

    private static Material getGoldenBoots() {
        if (Version.getVersion().isNewAPI())
            return Material.GOLDEN_LEGGINGS;

        return Material.getMaterial("GOLD_LEGGINGS");
    }

    public static ArmorType getPlayerArmorType(Player player) {
        EntityEquipment equip = player.getEquipment();

        ItemStack item1 = equip.getLeggings();
        ItemStack item2 = equip.getBoots();

        if (item1 != null && item2 != null) {
            Material leggings = item1.getType();
            Material boots = item2.getType();

            return ArmorType.getByArmor(leggings, boots);
        }

        return null;
    }

    public static ArmorType getByArmor(Material leggings, Material boots) {
        if (leggings == null || boots == null)
            return null;

        ArmorType result = ArmorType.BY_LEGGINGS.get(leggings);
        if (result == null)
            result = ArmorType.BY_BOOTS.get(boots);

        return result;
    }

    public static ArmorType getByCraftMaterial(Material type) {
        return type != null ? ArmorType.BY_CRAFT_TYPE.get(type) : null;
    }

    public static ArmorType getByName(String s) {
        if (s == null)
            return null;

        switch (s.toUpperCase()) {
            case "LEATHER":
                return LEATHER;
            case "GOLD":
                return GOLD;
            case "CHAIN":
                return CHAIN;
            case "IRON":
                return IRON;
            case "DIAMOND":
                return DIAMOND;

            default:
                return null;
        }

    }

    public Material getLeggings() {
        return this.leggings;
    }

    public Material getBoots() {
        return this.boots;
    }

    @Override
    public String toString() {
        return this.type;
    }

}