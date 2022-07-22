package com.slyvr.api.event.shop;

import com.slyvr.api.shop.Category;
import com.slyvr.api.shop.Shop;
import org.bukkit.event.Event;

public abstract class ShopEvent extends Event {

    protected Shop shop;
    protected Category category;

    public ShopEvent(Shop shop, Category category) {

        this.shop = shop;
        this.category = category;
    }

    public final Shop getShop() {
        return this.shop;
    }

    public final Category getShopCategory() {
        return this.category;
    }

}