package com.slyvr.api.generator;

import com.google.common.base.Preconditions;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Resource {

    public static final Resource EMERALD = new Resource("Emerald", Material.EMERALD, Material.EMERALD_BLOCK, ChatColor.DARK_GREEN);
    public static final Resource DIAMOND = new Resource("Diamond", Material.DIAMOND, Material.DIAMOND_BLOCK, ChatColor.AQUA);
    public static final Resource GOLD = new Resource("Gold", Material.GOLD_INGOT, Material.GOLD_BLOCK, ChatColor.GOLD);
    public static final Resource IRON = new Resource("Iron", Material.IRON_INGOT, Material.IRON_BLOCK, ChatColor.WHITE);
    public static final Resource FREE = new Resource("Free", Material.AIR, Material.AIR, ChatColor.GREEN);

    private static final Map<String, Resource> BY_NAME = new LinkedHashMap<>();
    private static final Map<Material, Resource> BY_TYPE = new EnumMap<>(Material.class);
    private static final Map<Material, Resource> BY_BLOCK = new EnumMap<>(Material.class);

    static {
        registerResource(Resource.EMERALD);
        registerResource(Resource.DIAMOND);
        registerResource(Resource.GOLD);
        registerResource(Resource.IRON);
        registerResource(Resource.FREE);
    }

    private final String name;

    private final Material resource;
    private final Material block;

    private final ChatColor color;

    public Resource(String name, Material resource, Material block, ChatColor color) {
        Preconditions.checkNotNull(name, "Resource name cannot be null!");
        Preconditions.checkNotNull(resource, "Resource type cannot be null!");
        Preconditions.checkNotNull(block, "Resource block cannot be null!");
        Preconditions.checkArgument(block.isBlock(), "Resource block type is not a block!");
        Preconditions.checkNotNull(color, "Resource color cannot be null!");

        this.name = name;
        this.resource = resource;
        this.block = block;
        this.color = color;
    }

    public static Resource[] values() {
        return Resource.BY_NAME.values().toArray(new Resource[Resource.BY_NAME.size()]);
    }

    public static Resource getByName(String name) {
        return name != null ? Resource.BY_NAME.get(name.toLowerCase()) : null;
    }

    public static Resource getByMaterial(Material type) {
        return type != null ? Resource.BY_TYPE.get(type) : null;
    }

    public static Resource getByBlockMaterial(Material type) {
        return type != null && type.isBlock() ? Resource.BY_BLOCK.get(type) : null;
    }

    public static void registerResource(Resource resource) {
        if (resource == null)
            return;

        String name = resource.name.toLowerCase();
        if (Resource.BY_NAME.get(name) != null)
            throw new IllegalArgumentException("Cannot register resource with the same name!");

        if (Resource.BY_TYPE.get(resource.resource) != null)
            throw new IllegalArgumentException("Cannot register resource with the same drop type!");

        if (Resource.BY_BLOCK.get(resource.block) != null)
            throw new IllegalArgumentException("Cannot register resource with the same block type!");

        Resource.BY_NAME.put(name, resource);
        Resource.BY_TYPE.put(resource.resource, resource);
        Resource.BY_BLOCK.put(resource.block, resource);
    }

    public static boolean canRegisterResource(Resource resource) {
        return Resource.BY_NAME.get(resource.name.toLowerCase()) == null && Resource.BY_TYPE.get(resource.resource) == null
                && Resource.BY_BLOCK.get(resource.block) == null;
    }

    public String getName() {
        return this.name;
    }

    public Material getMaterial() {
        return this.resource;
    }

    public Material getBlock() {
        return this.block;
    }

    public ChatColor getChatColor() {
        return this.color;
    }

    public String getColoredName() {
        return this.color + this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.block, this.color, this.name.toLowerCase(), this.resource);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Resource))
            return false;

        Resource other = (Resource) obj;
        return this.name.equalsIgnoreCase(other.name) && this.resource == other.resource && this.block == other.block && this.color == other.color;
    }

}