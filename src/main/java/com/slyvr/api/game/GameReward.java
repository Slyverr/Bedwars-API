package com.slyvr.api.game;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class GameReward {

    private final Map<String, Reward> increment_history = new HashMap<>();
    private final Map<String, Reward> decrement_history = new HashMap<>();

    private int total;

    /**
     * Gets the history of added rewards with their add reason.
     *
     * @return {@code Map} whose key is the add reason and the value is its amount
     */
    public final Map<String, Integer> getIncrementHistory() {
        Map<String, Integer> result = new HashMap<>(increment_history.size());

        for (Reward reward : increment_history.values())
            result.put(reward.reason, reward.amount);

        return result;
    }

    /**
     * Gets the history of removed rewards with their remove reason.
     *
     * @return {@code Map} whose key is the add reason and the value is its amount
     */
    public final Map<String, Integer> getDecrementHistory() {
        Map<String, Integer> result = new HashMap<>(decrement_history.size());

        for (Reward reward : decrement_history.values())
            result.put(reward.reason, reward.amount);

        return result;
    }

    /**
     * Gets total amount of this reward.
     *
     * @return Rewards's total amount
     */
    public final int getTotalAmount() {
        return this.total;
    }

    /**
     * Increments reward's amount.
     *
     * @param amount Amount to increment by.
     * @param reason Increment's reason.
     */
    public final void increment(int amount, String reason) {
        Preconditions.checkArgument(amount > 0, "Amount must be greater than 0!");
        Preconditions.checkNotNull(reason, "Reason cannot be null!");

        Reward reward = increment_history.get(reason.toLowerCase());
        if (reward == null)
            increment_history.put(reason.toLowerCase(), reward = new Reward(reason));

        reward.increment(amount);
        this.total += amount;
    }

    /**
     * Decrements reward's amount.
     *
     * @param amount Amount to decrement by.
     * @param reason Decrement's reason.
     */
    public final void decrement(int amount, String reason) {
        Preconditions.checkArgument(amount > 0, "Amount must be greater than 0!");
        Preconditions.checkNotNull(reason, "Reason cannot be null!");

        Reward reward = decrement_history.get(reason.toLowerCase());
        if (reward == null)
            return;

        reward.decrement(amount);
        this.total = Math.max(total - amount, 0);
    }

    /**
     * Gets an hoverable text, this text will be shown in the reward summary.
     *
     * @return An hoverable text
     */
    public abstract BaseComponent toHoverableText();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof GameReward))
            return false;

        GameReward that = (GameReward) o;
        return total == that.total && increment_history.equals(that.increment_history) && decrement_history.equals(that.decrement_history);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(increment_history, decrement_history, total);
    }

    static class Reward {

        private final String reason;
        private int amount;

        public Reward(String reason) {
            this.reason = reason;
        }

        private void increment(int amount) {
            this.amount += amount;
        }

        private void decrement(int amount) {
            this.amount -= amount;
            if (amount < 0)
                this.amount = 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(reason.toLowerCase(), amount);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (!(o instanceof Reward))
                return false;

            Reward reward = (Reward) o;
            return amount == reward.amount && reason.equalsIgnoreCase(reward.reason);
        }


    }
}