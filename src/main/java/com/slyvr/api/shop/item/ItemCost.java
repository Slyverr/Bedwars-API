package com.slyvr.api.shop.item;

import com.slyvr.api.generator.Resource;

import java.util.Objects;

public class ItemCost implements Cloneable {

    private Resource resource;
    private int price;

    public ItemCost(Resource resource, int price) {

        setResource(resource);
        setPrice(price);
    }

    public ItemCost(ItemCost cost) {
        this.resource = cost.resource;
        this.price = cost.price;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setResource(Resource rsc) {
        if (rsc != null && rsc != Resource.FREE) {
            this.resource = rsc;
            return;
        }

        this.resource = Resource.FREE;
        this.price = 0;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
            return;
        }

        setResource(Resource.FREE);
    }

    @Override
    public ItemCost clone() {
        try {
            return (ItemCost) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "ItemCost [Resource=" + this.resource + ", Price=" + this.price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.price, this.resource);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof ItemCost))
            return false;

        ItemCost other = (ItemCost) obj;
        return this.price == other.price && Objects.equals(this.resource, other.resource);
    }

}