package com.slyvr.api.game.player;

import com.slyvr.api.game.GameReward;

import java.util.List;

public interface GameRewardManager {

    List<GameReward> getRewards();

    boolean addReward(GameReward reward);

    boolean removeReward(GameReward reward);

    GameReward getExpReward();

    GameReward getCoinsReward();

}