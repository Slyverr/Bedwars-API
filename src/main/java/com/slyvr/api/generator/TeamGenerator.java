package com.slyvr.api.generator;

import org.bukkit.Material;

import java.util.Set;

public interface TeamGenerator extends ItemGenerator {

    Set<DropItem> getDrops();

    boolean addDrop(DropItem item);

    DropItem getDrop(Material material);

    boolean removeDrop(DropItem item);

    boolean contains(DropItem item);

}