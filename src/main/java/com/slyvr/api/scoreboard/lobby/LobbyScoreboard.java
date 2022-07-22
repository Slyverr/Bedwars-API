package com.slyvr.api.scoreboard.lobby;

import com.slyvr.api.user.Statistic;
import org.bukkit.entity.Player;

import java.util.Map;

public interface LobbyScoreboard {

    Map<Integer, Statistic> getStatistics();

    Statistic getStatistic(int line);

    void setStatistic(int line, Statistic stat);

    Statistic removeStatistic(int line);

    LobbyBoardLineType getLineType(int line);

    void setLineType(int line, LobbyBoardLineType type);

    void update(Player player);

}