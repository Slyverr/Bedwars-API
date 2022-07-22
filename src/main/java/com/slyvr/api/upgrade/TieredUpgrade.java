package com.slyvr.api.upgrade;

public interface TieredUpgrade extends Upgrade, Cloneable {

    int getMaximumTier();

    int getNextTier();

    int getCurrentTier();

    void setCurrentTier(int tier);

    int getPreviousTier();

    TieredUpgrade clone();

}