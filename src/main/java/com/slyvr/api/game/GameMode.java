package com.slyvr.api.game;

import com.google.common.base.Preconditions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class GameMode {

	public static final GameMode SOLO = new GameMode("Solo", 1, 8); // 8
	public static final GameMode DUO = new GameMode("Doubles", 2, 8); // 16
	public static final GameMode TRIO = new GameMode("3v3v3v3", 3, 4); // 12
	public static final GameMode QUATUOR = new GameMode("4v4v4v4", 4, 4); // 16

	private static final Map<String, GameMode> BY_NAME = new LinkedHashMap<>();

	static {
		GameMode.registerGameMode(GameMode.SOLO);
		GameMode.registerGameMode(GameMode.DUO);
		GameMode.registerGameMode(GameMode.TRIO);
		GameMode.registerGameMode(GameMode.QUATUOR);
	}

	private final String name;
	private final int teamMax;
	private final int teams;

	public GameMode(String name, int teamMax, int teams) {
		Preconditions.checkNotNull(name, "Mode name cannot be null!");
		Preconditions.checkArgument(teams <= 8 && teams >= 2, "Mode teams should be between 8 and 2!");

		this.name = name;
		this.teamMax = teamMax;
		this.teams = teams;
	}

	public static void registerGameMode(GameMode mode) {
		if (!canRegisterGameMode(mode))
			throw new IllegalStateException("Cannot register existing game mode");

		GameMode.BY_NAME.put(mode.name.toLowerCase(), mode);
	}

	public static boolean canRegisterGameMode(GameMode mode) {
		return mode != null && !GameMode.BY_NAME.containsKey(mode.name.toLowerCase());
	}

	public static GameMode getByName(String name) {
		return name != null ? BY_NAME.get(name.toLowerCase()) : null;
	}

	/**
	 * Gets {@code GameMode} from a {@code String}.
	 *
	 * @param name A {@code String} to get {@code GameMode} from
	 *
	 * @return {@code GameMode} from the given {@code string}, otherwise null
	 */
	public static GameMode fromString(String name) {
		return name != null ? GameMode.BY_NAME.get(name.toLowerCase()) : null;
	}

	public static GameMode[] values() {
		return GameMode.BY_NAME.values().toArray(new GameMode[GameMode.BY_NAME.size()]);
	}

	/**
	 * Gets name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets Maximum team players
	 *
	 * @return Maximum team players
	 */
	public int getTeamMax() {
		return this.teamMax;
	}

	/**
	 * Gets maximum teams of this GameMode
	 *
	 * @return maximum teams of this GameMode
	 */
	public int getMaxTeams() {
		return this.teams;
	}

	/**
	 * Gets maximum players of this GameMode
	 *
	 * @return maximum players of this GameMode
	 */
	public int getGameMax() {
		return this.teamMax * this.teams;
	}

	@Override
	public String toString() {
		return "GameMode [Name=" + this.name + ", Team-max=" + this.teamMax + ", Teams=" + this.teams + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name.toLowerCase(), this.teamMax, this.teams);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof GameMode))
			return false;

		GameMode other = (GameMode) obj;
		if ((this.teamMax != other.teamMax) || (this.teams != other.teams))
			return false;

		return this.name.equalsIgnoreCase(other.name);
	}

}