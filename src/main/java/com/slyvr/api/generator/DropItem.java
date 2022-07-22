package com.slyvr.api.generator;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class DropItem implements Cloneable {

    private final ItemStack item;

    private int limit;
    private int dropsPerMinute;

    public DropItem(ItemStack item, int dropsPerMin, int limit) {
        Preconditions.checkNotNull(item, "Item cannot be null!");
        Preconditions.checkArgument(dropsPerMin > 0, "Minimum drops per minute is 1!");
        Preconditions.checkArgument(limit > 0, "Drop's limit must be atleast 1!");

        this.item = item;
        this.limit = limit;

        this.dropsPerMinute = dropsPerMin;
    }

    public ItemStack getItem() {
        return this.item.clone();
    }

    public Material getType() {
        return this.item.getType();
    }

    public int getDropsPerMinute() {
        return this.dropsPerMinute;
    }

    public void setDropsPerMinute(int drops) {
        if (drops <= 0)
            return;

        this.dropsPerMinute = drops;
    }

    public int getDropLimit() {
        return this.limit;
    }

    public void setDropLimit(int limit) {
        if (limit > 0)
            this.limit = limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof DropItem))
            return false;

        DropItem other = (DropItem) obj;
        return Objects.equals(this.item, other.item);
    }

    @Override
    public DropItem clone() {
        try {
            return (DropItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}