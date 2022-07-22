package com.slyvr.api.shop.item;

import com.google.common.base.Preconditions;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class TieredItemStack {

    private final List<ItemStack> tiers;

    private int current = 0;

    public TieredItemStack(List<ItemStack> tiers) {
        Preconditions.checkNotNull(tiers, "Tiers cannot be null");

        List<ItemStack> result = new ArrayList<>(tiers.size());
        for (ItemStack item : tiers)
            if (item != null)
                result.add(item);

        if (result.isEmpty())
            throw new IllegalArgumentException("Tiers cannot be empty");

        this.tiers = result;
    }

    public List<ItemStack> getTiers() {
        return new ArrayList<>(this.tiers);
    }

    public ItemStack getTier(int tier) {
        return isValidTier(tier) ? this.tiers.get(tier - 1) : null;
    }

    // Next
    public ItemStack next() {
        return isValidIndex(this.current) ? this.tiers.get(this.current) : null;
    }

    public int getNextTier() {
        int result = this.current + 1;
        return isValidTier(result) ? result : this.tiers.size();
    }

    public boolean hasNext() {
        return isValidTier(this.current + 1);
    }

    // Current
    public ItemStack current() {
        int result = this.current - 1;
        return isValidIndex(result) ? this.tiers.get(result) : null;
    }

    public int getCurrentTier() {
        return this.current;
    }

    public void setCurrentTier(int tier) {
        if (tier >= 0 && tier <= this.tiers.size())
            this.current = tier;
    }

    // Previous
    public ItemStack previous() {
        int result = this.current - 2;
        return isValidIndex(result) ? this.tiers.get(result) : null;
    }

    public int getPreviousTier() {
        int result = this.current - 1;
        return isValidTier(result) ? result : 1;
    }

    public boolean hasPrevious() {
        return isValidTier(this.current - 1);
    }

    // Size
    public int size() {
        return this.tiers.size();
    }

    public int getMaximumTier() {
        return this.tiers.size();
    }

    // Contains
    public boolean contains(ItemStack item) {
        return item != null && this.tiers.contains(item);
    }

    public boolean contains(ItemStack item, Predicate<ItemStack> predicate) {
        if (item == null)
            return false;

        if (predicate == null)
            return this.tiers.contains(item);

        for (ItemStack tier : this.tiers)
            if (predicate.test(tier))
                return true;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tiers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof TieredItemStack))
            return false;

        TieredItemStack other = (TieredItemStack) obj;
        return Objects.equals(this.tiers, other.tiers);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.tiers.size();
    }

    private boolean isValidTier(int tier) {
        return tier >= 1 && tier <= this.tiers.size();
    }

}