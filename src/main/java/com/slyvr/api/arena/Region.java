package com.slyvr.api.arena;

import com.google.common.base.Preconditions;
import com.slyvr.api.util.LocationUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Region implements ConfigurationSerializable {

	private final World world;
	private final Location pos1;
	private final Location pos2;

	public Region(Location pos1, Location pos2) {
		Preconditions.checkNotNull(pos1, "Region's 1st position cannot be null!");
		Preconditions.checkNotNull(pos1, "Region's 2nd position cannot be null!");

		Region.checkWorlds(pos1, pos2);

		this.world = pos1.getWorld();
		this.pos1 = pos1.clone();
		this.pos2 = pos2.clone();
	}

	public Region(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
		this(new Location(world, x1, y1, z1), new Location(world, x2, y2, z2));
	}

	public static void checkWorlds(Location loc1, Location loc2) {
		if (!loc1.getWorld().equals(loc2.getWorld()))
			throw new IllegalArgumentException("Cannot handle different Worlds!");

	}

	public static Region deserialize(Map<String, Object> values) {
		Location loc1 = LocationUtils.deserialize((String) values.get("position-1"));
		Location loc2 = LocationUtils.deserialize((String) values.get("position-1"));

		return loc1 != null && loc2 != null ? new Region(loc1, loc2) : null;
	}

	public Location getFirstPosition() {
		return this.pos1.clone();
	}

	public Location getSecondPosition() {
		return this.pos2.clone();
	}

	public World getWorld() {
		return this.world;
	}

	public double getMinX() {
		return Math.min(this.pos1.getX(), this.pos2.getX());
	}

	public double getMaxX() {
		return Math.max(this.pos1.getX(), this.pos2.getX());
	}

	public double getMinY() {
		return Math.min(this.pos1.getY(), this.pos2.getY());
	}

	public double getMaxY() {
		return Math.max(this.pos1.getY(), this.pos2.getY());
	}

	public double getMinZ() {
		return Math.min(this.pos1.getZ(), this.pos2.getZ());
	}

	public double getMaxZ() {
		return Math.max(this.pos1.getZ(), this.pos2.getZ());
	}

	public boolean isInside(Block block) {
		return block != null && isInside(block.getLocation());
	}

	public boolean isInside(Entity player) {
		return player != null && isInside(player.getLocation());
	}

	public boolean isInside(Location loc) {
		if ((loc == null) || loc.getX() < getMinX() || loc.getX() > getMaxX())
			return false;

		if (loc.getY() < getMinY() || loc.getY() > getMaxY())
			return false;

		return !(loc.getZ() < getMinZ()) && !(loc.getZ() > getMaxZ());
	}

	@Override
	public String toString() {
		int x1 = this.pos1.getBlockX();
		int y1 = this.pos1.getBlockY();
		int z1 = this.pos1.getBlockZ();

		int x2 = this.pos2.getBlockX();
		int y2 = this.pos2.getBlockY();
		int z2 = this.pos2.getBlockZ();

		return "Region [World=" + this.world.getName() + ", Pos-1={x=" + x1 + ",y=" + y1 + ",z=" + z1 + "}" + ", Pos-2={x=" + x2 + ",y" + y2 + ",z=" + z2
				+ "}]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.pos1, this.pos2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Region))
			return false;

		Region other = (Region) obj;
		return this.pos1.equals(other.pos1) && this.pos2.equals(other.pos2);
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new HashMap<>();

		result.put("position-1", LocationUtils.serialize(this.pos1, false));
		result.put("position-2", LocationUtils.serialize(this.pos2, false));

		return result;
	}

}