package com.slyvr.api.shop.item;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ItemDescription implements Cloneable {

    private List<String> description = new ArrayList<>();

    public ItemDescription(List<String> description) {
        setDescription(description);
    }

    public ItemDescription(ItemDescription description) {
        this(description.description);
    }

    public ItemDescription() {
    }

    public List<String> getDescription() {
        return new ArrayList<>(this.description);
    }

    public void setDescription(List<String> description) {
        if (description != null)
            this.description = new ArrayList<>(description);
    }

    public void apply(List<String> list) {
        if (list == null)
            return;

        for (String line : this.description)
            list.add(ChatColor.GRAY + line);
    }

    public int getSize() {
        return this.description.size();
    }

    public boolean isEmpty() {
        return this.description.isEmpty();
    }

    @Override
    public ItemDescription clone() {
        try {
            ItemDescription result = (ItemDescription) super.clone();
            result.description = new ArrayList<>(this.description);

            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}