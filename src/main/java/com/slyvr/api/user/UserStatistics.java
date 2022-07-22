package com.slyvr.api.user;

import com.slyvr.api.game.GameStatistic;
import com.slyvr.api.game.player.GameStatisticManager;

import java.util.EnumMap;
import java.util.Map;

public final class UserStatistics implements Cloneable {

    private final Map<Statistic, Integer> stats = new EnumMap<>(Statistic.class);

    public UserStatistics() {
    }

    public Map<Statistic, Integer> getStats() {
        return this.stats;
    }

    public int getStatistic(Statistic stat) {
        Integer result = this.stats.get(stat);
        return result != null ? result : 0;
    }

    public float getKillDeathRatio() {
        Integer kills = this.stats.get(Statistic.KILLS);
        if (kills == null)
            return 0.0F;

        Integer deaths = this.stats.get(Statistic.DEATHS);
        if (deaths == null || deaths == 0)
            return 0.0F;

        return (float) kills / deaths;
    }

    public float getFinalKillDeathRatio() {
        Integer kills = this.stats.get(Statistic.FINAL_KILLS);
        if (kills == null)
            return 0.0F;

        Integer deaths = this.stats.get(Statistic.FINAL_DEATHS);
        if (deaths == null || deaths == 0)
            return 0.0F;

        return (float) kills / deaths;
    }

    public void setStatistic(Statistic stat, int value) {
        if (stat != null && value >= 0)
            this.stats.put(stat, value);
    }

    public void incrementStatistic(Statistic stat, int value) {
        if (stat == null || value <= 0)
            return;

        Integer old = stats.get(stat);

        this.stats.put(stat, old != null ? old + value : value);
    }

    public void decrementStatistic(Statistic stat, int value) {
        if (stat == null || value <= 0)
            return;

        Integer old = stats.get(stat);
        if (old == null)
            return;

        this.stats.put(stat, Math.max(old - value, 0));
    }

    public void incrementStatistics(GameStatisticManager stats) {
        if (stats == null)
            return;

        incrementStatistic(Statistic.KILLS, stats.getStatistic(GameStatistic.KILLS));
        incrementStatistic(Statistic.DEATHS, stats.getStatistic(GameStatistic.DEATHS));
        incrementStatistic(Statistic.FINAL_KILLS, stats.getStatistic(GameStatistic.FINAL_KILLS));
        incrementStatistic(Statistic.FINAL_DEATHS, stats.getStatistic(GameStatistic.FINAL_DEATHS));
        incrementStatistic(Statistic.BED_BROKEN, stats.getStatistic(GameStatistic.BED_BROKEN));
        incrementStatistic(Statistic.BED_LOSSES, stats.getStatistic(GameStatistic.BED_LOST));
    }

    public void decrementStatistics(GameStatisticManager stats) {
        if (stats == null)
            return;

        decrementStatistic(Statistic.KILLS, stats.getStatistic(GameStatistic.KILLS));
        decrementStatistic(Statistic.DEATHS, stats.getStatistic(GameStatistic.DEATHS));
        decrementStatistic(Statistic.FINAL_KILLS, stats.getStatistic(GameStatistic.FINAL_KILLS));
        decrementStatistic(Statistic.FINAL_DEATHS, stats.getStatistic(GameStatistic.FINAL_DEATHS));
        decrementStatistic(Statistic.BED_BROKEN, stats.getStatistic(GameStatistic.BED_BROKEN));
        decrementStatistic(Statistic.BED_LOSSES, stats.getStatistic(GameStatistic.BED_LOST));
    }

    @Override
    public UserStatistics clone() {
        try {
            return (UserStatistics) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}