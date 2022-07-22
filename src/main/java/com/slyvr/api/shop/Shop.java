package com.slyvr.api.shop;

import com.slyvr.api.game.player.GamePlayer;

import java.util.List;

public interface Shop {

    /**
     * Gets a list containing all categories of this shop
     *
     * @return list with all categories of this shop
     */
    List<Category> getCategories();

    /**
     *
     */
    void setCategories(List<Category> categories);

    /**
     * Gets the category at the given index
     *
     * @return Category at the given index if exists, otherwise null
     */
    Category getCategory(int index);

    /**
     * Adds this category to the shop
     *
     * @return true if the category has been added, otherwise false
     */
    boolean addCategory(Category category);

    /**
     * Removes this category from the shop
     *
     * @return true if the category has been remove, otherwise false
     */
    boolean removeCategory(Category category);

    /**
     * Removes the category at the given index if exists
     *
     * @return The old category if exists, otherwise null
     */
    Category removeCategory(int index);

    /**
     * Sets the given category at the given index
     */
    void setCategory(int index, Category category);

    /**
     * Opens the shop to the player at the given category
     *
     * @return true if the shop has opened, otherwise false
     */
    boolean openShop(GamePlayer gp, Category category);

    /**
     * Opens the shop to the player with the category at the given index
     *
     * @return if the category exists and the shop has opened, otherwise false
     */
    boolean openShop(GamePlayer gp, int index);

    /**
     * Opens the shop to the player at the first category if exists
     *
     * @return true if the shop successfully was opened, otherwise false
     */
    boolean openShop(GamePlayer gp);

    /**
     * Checks if this shop contains this category
     *
     * @param category The category to check
     *
     * @return true if the shop contain this category, otherwise false
     */
    boolean contains(Category category);

}