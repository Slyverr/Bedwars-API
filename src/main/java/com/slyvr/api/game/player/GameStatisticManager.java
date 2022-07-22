package com.slyvr.api.game.player;

import com.slyvr.api.game.GameStatistic;

import java.util.Map;

public interface GameStatisticManager {

    Map<GameStatistic, Integer> getStats();

    int getStatistic(GameStatistic stat);

    void incrementStatistic(GameStatistic stat, int value);

    void decrementStatistic(GameStatistic stat, int value);

    void setStatistic(GameStatistic stat, int value);

}